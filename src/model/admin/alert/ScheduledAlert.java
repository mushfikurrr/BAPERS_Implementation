package model.admin.alert;

import model.database.DB_Connection;
import model.database.I_Bapers;
import model.jobs.job.Job;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledAlert {

    private Alert alert;
    private I_Bapers controller;
    private boolean isRunning;
    ScheduledFuture<?> alertHandle;
    private JFrame parentPanel;
    private Connection conn;

    public ScheduledAlert(Alert alert, JFrame parentPanel, I_Bapers controller, DB_Connection conn) {
        this.conn = conn.getConn();
        this.alert = alert;
        this.controller = controller;
        this.parentPanel = parentPanel;
    }

    public boolean canRunAlert() {
        return alert.getTimeUntilExecutionInSeconds() > 0 && !isRunning;
    }

    public void runAlert() {
        if (canRunAlert()) {
            isRunning = true;
            alertHandle = controller.getScheduler().schedule(alertRunner, alert.getTimeUntilExecutionInSeconds(), TimeUnit.SECONDS);
            controller.getLoadedAlerts().add(this);
        }else if (alert.getTimeUntilExecutionInSeconds() < 0) {
            // Alert is already completed, get rid of it
            removeFromLoadedAlerts();
        }
    }

    private Timestamp getPaymentDeadlineFromJobId(int jobId) {
        Timestamp paymentDeadline = null;
        try {
            PreparedStatement st = conn.prepareStatement("SELECT Payment_deadline FROM Job WHERE Job_ID = ?");
            st.setInt(1, jobId);
            ResultSet rs = st.executeQuery();
            paymentDeadline = rs.getTimestamp("Payment_deadline");
            rs.close();
            st.close();
        } catch (Exception e) { e.printStackTrace(); }
        return paymentDeadline;
    }

    public void removeFromLoadedAlerts() {
        controller.removeAlert(getAlert());
        controller.getLoadedAlerts().remove(this);
    }

    Runnable alertRunner = () -> {
        if (alert.getName().equals("job")) {
            if (controller.getCurrentUser().getRole().equals("Shift Manager") || controller.getCurrentUser().getRole().equals("Office Manager")) {
                JOptionPane.showMessageDialog(
                        parentPanel,
                        "Job deadline has been reached!",
                        "BAPERS", JOptionPane.WARNING_MESSAGE
                );
            }
        }else if (alert.getName().equals("payment")) {
            if (controller.getCurrentUser().getRole().equals("Shift Manager") || controller.getCurrentUser().getRole().equals("Office Manager")) {
                Job job = (Job) controller.getJob().read(alert.getJobId());
                if (!job.getJob_status().equals("Completed")) {
                    JOptionPane.showMessageDialog(
                            parentPanel,
                            "Payment deadline requires payment!",
                            "BAPERS", JOptionPane.WARNING_MESSAGE
                    );
                    LocalDateTime newTime = getPaymentDeadlineFromJobId(alert.getJobId()).toLocalDateTime().plusMinutes(15);
                    controller.getAlertTransaction().create("payment", "", newTime, alert.getJobId());
                }else{
                    JOptionPane.showMessageDialog(
                            parentPanel,
                            "Payment deadline has been reached!",
                            "BAPERS", JOptionPane.WARNING_MESSAGE
                    );
                }
            }
        }
        removeFromLoadedAlerts();
        isRunning = false;
    };

    public void cancelSchedule() {
        if (isRunning) {
            alertHandle.cancel(false);
        }
    }

    public boolean isRunning() {
        return isRunning;
    }

    public Alert getAlert() {
        return alert;
    }

}

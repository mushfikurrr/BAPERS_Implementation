/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import model.database.Controller;
import model.database.I_Bapers;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author kehkshan and Manpreet
 */
public class UpdateTask extends javax.swing.JPanel {

    I_Bapers bapers = new Controller();

    /**
     * Creates new form UpdateTask
     */
    public UpdateTask(int task_id) {
        initComponents(task_id);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(int task_id) {

        jLabel1 = new javax.swing.JLabel();
        save_button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        select_status_combo_box = new javax.swing.JComboBox<>();
        cancel_button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(157, 195, 230));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 23, 71));
        jLabel1.setText("Update Task");

        save_button.setBackground(new java.awt.Color(1, 23, 71));
        save_button.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        save_button.setForeground(new java.awt.Color(157, 195, 230));
        save_button.setText("Save");
        save_button.setBorderPainted(false);
        save_button.setFocusPainted(false);
        save_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                save_buttonMouseClicked(evt, task_id);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 23, 71));
        jLabel2.setText("Status");

        select_status_combo_box.setBackground(new java.awt.Color(1, 23, 71));
        select_status_combo_box.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        select_status_combo_box.setForeground(new java.awt.Color(157, 195, 230));
        select_status_combo_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Status", "Pending", "Processing", "Completed" }));

        cancel_button.setBackground(new java.awt.Color(1, 23, 71));
        cancel_button.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cancel_button.setForeground(new java.awt.Color(157, 195, 230));
        cancel_button.setText("Cancel");
        cancel_button.setBorderPainted(false);
        cancel_button.setFocusPainted(false);
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 23, 71));
        jLabel3.setText("Bapers");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(select_status_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(save_button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(cancel_button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel1)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(select_status_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_button)
                    .addComponent(cancel_button))
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void save_buttonMouseClicked(MouseEvent evt, int task_id){
        if (!(select_status_combo_box.getSelectedItem() == "Select Status")){
            bapers.updateTaskStatus(task_id, String.valueOf(select_status_combo_box.getSelectedItem()));
            JDialog frame = (JDialog) SwingUtilities.getWindowAncestor(this);
            frame.dispose();
        }
        else {
            JOptionPane.showMessageDialog(
                    this,
                    "Please select status.",
                    "BAPERS", JOptionPane.ERROR_MESSAGE
            );
        }
    }
    private void cancel_buttonActionPerformed(ActionEvent evt){
        JDialog frame = (JDialog) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton save_button;
    private javax.swing.JComboBox<String> select_status_combo_box;
    // End of variables declaration//GEN-END:variables
}

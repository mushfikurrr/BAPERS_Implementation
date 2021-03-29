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
import java.sql.Date;
import java.util.regex.Pattern;

/**
 *
 * @author kehkshan and Manpreet
 */
public class CardPayment extends javax.swing.JPanel {

    private Controller bapers;
    private GUI f;
    private JPanel lastPanel;

    /**
     * Creates new form CardPayment
     */
    public CardPayment(int width, int height, double amount, Date date, int job_ID, I_Bapers bapers, GUI f) {
        initComponents(width, height, amount, date, job_ID, bapers, f);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(int width, int height, double amount, Date date, int job_ID, I_Bapers bapers, GUI f) {

        this.f = f;
        this.lastPanel = f.getCurrentPanel();
        f.setCurrentPanel(this);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        card_number_input = new javax.swing.JTextField();
        name_input = new javax.swing.JTextField();
        make_payment_button = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cancel_button = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        expiry_date = new javax.swing.JTextField();

        setBackground(new java.awt.Color(157, 195, 230));
        setMaximumSize(new java.awt.Dimension(width, height));
        setMinimumSize(new java.awt.Dimension(width, height));
        setPreferredSize(new java.awt.Dimension(width, height));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 23, 71));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Card Payment");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 23, 71));
        jLabel2.setText("Card Holder's Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 23, 71));
        jLabel3.setText("Card Number");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 23, 71));
        jLabel4.setText("Card Type");

        card_number_input.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        card_number_input.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        name_input.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        name_input.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        make_payment_button.setBackground(new java.awt.Color(1, 23, 71));
        make_payment_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        make_payment_button.setForeground(new java.awt.Color(157, 195, 230));
        make_payment_button.setText("Make Payment");
        make_payment_button.setBorder(null);
        make_payment_button.setBorderPainted(false);
        make_payment_button.setFocusPainted(false);
        make_payment_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                make_payment_buttonMouseClicked(evt, amount, date, job_ID);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 23, 71));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Bapers");

        cancel_button.setBackground(new java.awt.Color(1, 23, 71));
        cancel_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancel_button.setForeground(new java.awt.Color(157, 195, 230));
        cancel_button.setText("Cancel");
        cancel_button.setBorder(null);
        cancel_button.setBorderPainted(false);
        cancel_button.setFocusPainted(false);
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });

        jComboBox1.setBackground(new java.awt.Color(1, 23, 71));
        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(157, 195, 230));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Card Type", "Visa", "MasterCard", "Amex" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 23, 71));
        jLabel5.setText("Expiry Date");

        expiry_date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        expiry_date.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        expiry_date.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                expiry_dateFocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(make_payment_button, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(expiry_date, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(card_number_input, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name_input, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, 234, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(cancel_button, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(247, 247, 247))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(352, 352, 352))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(card_number_input, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(name_input, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(expiry_date, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(make_payment_button, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancel_button, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void make_payment_buttonMouseClicked(MouseEvent evt, double amount, Date date, int job_ID){
        Pattern pattern = Pattern.compile("^[0-9]*[1-9][0-9]*$");
        Pattern pattern2 = Pattern.compile("^\\d{4}\\-(0[1-9]|1[012])$");
        if (!card_number_input.getText().isEmpty() && !name_input.getText().isEmpty() && !(jComboBox1.getSelectedItem()=="Select Card Type")){
            if (pattern.matcher(card_number_input.getText()).matches() && pattern2.matcher(expiry_date.getText()).matches()  ){
                int id = bapers.createPayment("Card", amount, date, job_ID);
                String lastFourDigits = "";     //substring containing last 4 digits
                if (card_number_input.getText().length() > 4)
                {
                    lastFourDigits = card_number_input.getText().substring(card_number_input.getText().length() - 4);
                }
                else{ lastFourDigits = card_number_input.getText(); }
                bapers.createCard_payment(id, String.valueOf(jComboBox1.getSelectedItem()),expiry_date.getText(), lastFourDigits, amount, date, job_ID);
                f.generateInvoice(id);
                setVisible(false);
            }
        }
        else{
            JOptionPane.showMessageDialog(
                    this,
                    "Please fill out the fields.",
                    "BAPERS", JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void expiry_dateFocusGained(java.awt.event.FocusEvent evt) {
        expiry_date.setText("");
    }

    private void cancel_buttonActionPerformed(ActionEvent evt){
        JDialog frame = (JDialog) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_button;
    private javax.swing.JTextField card_number_input;
    private javax.swing.JTextField name_input;
    private javax.swing.JTextField expiry_date;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton make_payment_button;
    // End of variables declaration//GEN-END:variables
}

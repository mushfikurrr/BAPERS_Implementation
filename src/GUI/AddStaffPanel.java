/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import model.database.I_Bapers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author msy
 */
public class AddStaffPanel extends JPanel {
    private I_Bapers controller;
    private JTable staffTable;
    /**
     * Creates new form AddStaffPanel
     */
    public AddStaffPanel(I_Bapers controller, JTable staffTable) {
        this.controller = controller;
        this.staffTable = staffTable;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {
        passwordLabel = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        emailInput = new javax.swing.JTextField();
        phoneInput = new javax.swing.JTextField();
        roleLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        pageTitle = new java.awt.Label();
        passwordInput = new javax.swing.JPasswordField();
        nameLabel = new javax.swing.JLabel();
        TechnicianComboBox = new javax.swing.JComboBox<>();
        roleDropdown = new javax.swing.JComboBox<>();
        emailLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();

        setBackground(Style.LIGHT_BLUE);

        passwordLabel.setForeground(Style.DARK_BLUE);
        passwordLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        passwordLabel.setText("Password:");
        passwordLabel.setToolTipText("");

        nameInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        emailInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        phoneInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        phoneInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneInputActionPerformed(evt);
            }
        });

        roleLabel.setForeground(Style.DARK_BLUE);
        roleLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        roleLabel.setText("Role:");

        addButton.setBackground(Style.DARK_BLUE);
        addButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addButton.setForeground(Style.LIGHT_BLUE);
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionListener(evt);
            }
        });

        cancelButton.setBackground(Style.DARK_BLUE);
        cancelButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancelButton.setForeground(Style.LIGHT_BLUE);
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionListener(evt);
            }
        });

        pageTitle.setForeground(Style.DARK_BLUE);
        pageTitle.setAlignment(java.awt.Label.CENTER);
        pageTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pageTitle.setText("Add Staff");

        passwordInput.setInheritsPopupMenu(true);

        nameLabel.setForeground(Style.DARK_BLUE);
        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nameLabel.setText("Name:");

        roleDropdown.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        roleDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Office Manager", "Shift Manager", "Receptionist", "Technician" }));
        roleDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roleDropdownActionPerformed(e);

            }
        });

        emailLabel.setForeground(Style.DARK_BLUE);
        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        emailLabel.setText("Email:");

        phoneLabel.setForeground(Style.DARK_BLUE);
        phoneLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        phoneLabel.setText("Phone:");
        TechnicianComboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Copy Room", "Development", "Finishing", "Packing"}));
        if (TechnicianComboBox.getSelectedItem() != "Technician") {
            TechnicianComboBox.setVisible(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(pageTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(phoneLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(emailLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(roleLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(phoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(roleDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(TechnicianComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 254, Short.MAX_VALUE)
                                                .addComponent(addButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cancelButton)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(pageTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(phoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(phoneLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(roleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 7, Short.MAX_VALUE))
                                        .addComponent(roleDropdown, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                        .addComponent(TechnicianComboBox))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
    }

    private void roleDropdownActionPerformed(ActionEvent e) {
        if (roleDropdown.getSelectedItem() == "Technician") {
            TechnicianComboBox.setVisible(true);
        }else{
            TechnicianComboBox.setVisible(false);
        }
    }

    private void clearAllInputFields() {
        nameInput.setText("");
        emailInput.setText("");
        phoneInput.setText("");
        passwordInput.setText("");
    }

    private void cancelButtonActionListener(ActionEvent evt) {
        JDialog frame = (JDialog) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }

    private void addButtonActionListener(ActionEvent evt) {
        String name = nameInput.getText();
        String email = emailInput.getText();
        String phone = phoneInput.getText();
        String password = new String(passwordInput.getPassword());
        String role = (String) roleDropdown.getSelectedItem();
        String department = (String) TechnicianComboBox.getSelectedItem();
        boolean addStaffMember = false;
        if (role == "Technician") {
            addStaffMember = controller.addStaffMember(new String[]{name, email, phone, password, role, department});
        }else{
            addStaffMember = controller.addStaffMember(new String[]{name, email, phone, password, role});
        }

        if (addStaffMember) {
            clearAllInputFields();
            controller.populateStaffTable(staffTable);
        }else{
            JOptionPane.showMessageDialog(
                    this,
                    "There was an error with your addition",
                    "BAPERS", JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void phoneInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneInputActionPerformed
        // TODO add your handling code here:
    }

    private javax.swing.JButton addButton;
    private javax.swing.JComboBox<String> TechnicianComboBox;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField emailInput;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField nameInput;
    private javax.swing.JLabel nameLabel;
    private java.awt.Label pageTitle;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField phoneInput;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JComboBox<String> roleDropdown;
    private javax.swing.JLabel roleLabel;
}

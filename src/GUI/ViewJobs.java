package GUI;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.database.Controller;
import model.database.I_Bapers;
import model.jobs.job.Job;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manpreet
 */
public class ViewJobs extends javax.swing.JPanel {

    I_Bapers bapers = new Controller();
    private GUI f;
    private JPanel lastPanel;

    /**
     * Creates new form ViewJobs
     */
    public ViewJobs(int width, int height, GUI f) {
        initComponents(width, height, f);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(int width, int height, GUI f) {

        jLabel1 = new javax.swing.JLabel();
        filter = new javax.swing.JComboBox<>();
        refresh_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jobs_list_input = new javax.swing.JTable();
        back_button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(157, 195, 230));
        setMaximumSize(new java.awt.Dimension(width, height));
        setMinimumSize(new java.awt.Dimension(width, height));
        setPreferredSize(new java.awt.Dimension(width, height));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 23, 71));
        jLabel1.setText("Active Jobs");

        filter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        filter.setForeground(new java.awt.Color(1, 23, 71));
        filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascending", "Descending" }));
        filter.setPreferredSize(new java.awt.Dimension(81, 25));
        filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterActionPerformed(evt, jobs_list_input);
            }
        });

        refresh_button.setBackground(new java.awt.Color(1, 23, 71));
        refresh_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        refresh_button.setForeground(new java.awt.Color(157, 195, 230));
        refresh_button.setText("Refresh");
        refresh_button.setBorderPainted(false);
        refresh_button.setFocusPainted(false);
        refresh_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent  evt) {
                refresh_buttonMouseClicked(evt, jobs_list_input);
            }
        });

        jobs_list_input.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jobs_list_input.setForeground(new java.awt.Color(1, 23, 71));
        jobs_list_input.setModel(new javax.swing.table.DefaultTableModel(
            new String [] {
                "Job ID", "Description", "Priority", "Special Instruction", "Completion Deadline"
            },0
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        addJobs(jobs_list_input);
        jobs_list_input.setGridColor(new java.awt.Color(1, 23, 71));
        jobs_list_input.setSelectionBackground(new java.awt.Color(230, 238, 255));
        jobs_list_input.setSelectionForeground(new java.awt.Color(1, 23, 71));
        jScrollPane1.setViewportView(jobs_list_input);

        back_button.setBackground(new java.awt.Color(1, 23, 71));
        back_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        back_button.setForeground(new java.awt.Color(157, 195, 230));
        back_button.setText("Back");
        back_button.setBorderPainted(false);
        back_button.setFocusPainted(false);
        back_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                back_buttonMouseClicked(evt);
            }
        });


        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 23, 71));
        jLabel2.setText("Bapers");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(refresh_button, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(373, 373, 373))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refresh_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addJobs(JTable table) {

        DefaultTableModel model = (DefaultTableModel)table.getModel();
        ArrayList<Job> jobs = bapers.getActiveJobs();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for(Job job : jobs){
            model.addRow(new Object[]{job.getJob_ID(), job.getJob_desc(), job.getPriority(), job.getSpecial_instructions(),job.getCompletion_deadline().format(formatter)});
        }
        table.setModel(model);
    }

    private void refresh_buttonMouseClicked(java.awt.event.MouseEvent evt, JTable table) {

        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0);
        ArrayList<Job> jobs = bapers.getActiveJobs();
        for(Job job : jobs){
            model.addRow(new Object[]{job.getJob_ID(), job.getJob_desc(), job.getPriority(), job.getSpecial_instructions(),job.getCompletion_deadline()});
        }
        table.setModel(model);
    }

    private void filterActionPerformed(ActionEvent evt, JTable table) {

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        int columnIndexToSort = 0;
        if (filter.getSelectedItem() == "Ascending"){
            sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
        }
        else {
            sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
        }

        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }

    private void back_buttonMouseClicked(java.awt.event.MouseEvent evt) {
        f.setLastPanel(lastPanel);
        f.getLastPanel().setVisible(true);
        f.remove(f.getCurrentPanel());
        f.setCurrentPanel(lastPanel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JComboBox<String> filter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jobs_list_input;
    private javax.swing.JButton refresh_button;
    // End of variables declaration//GEN-END:variables
}
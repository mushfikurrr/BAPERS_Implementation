package GUI;

import model.database.I_Bapers;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class RetrieveCustomer extends JPanel {

	/**
	 *private global variables in RetrieveCustomer
	 */
	private JLabel retrieveLabel;
	private JTable customerTable;
	private JButton backButton, retrieveButton, refresh, remove, newCust;
	private I_Bapers cT;
	private GUI f;
	private JPanel lastPanel;
	private String[][] data;
	private ArrayList<String[]> customers;

	/**
	 * constructor for panel, initialise components for panel, initalise global variables and add layout manager
	 * @param width
	 * @param height
	 * @param f
	 * @param cT
	 */
	public RetrieveCustomer(int width, int height, GUI f, I_Bapers cT) {
		this.f = f;
		this.lastPanel = f.getCurrentPanel();
		this.cT = cT;
		f.setLastPanel(lastPanel);
		f.setCurrentPanel(this);

		setSize(width, height);
		setName("Customer Details");
		setBackground(new Color(157, 195, 230));

		/**
		 *initialises components for panel
		 */
		customerTable = new JTable();
		String[] columnNames = {"Name", "Account no.", "Address", "Phone", "Customer Type", "Discount type", "Company"};
		customerTable.setModel(new DefaultTableModel(columnNames,0) {
			boolean[] canEdit = new boolean[]{
					false, false, false, false, false, false, false
			};
				public boolean isCellEditable ( int rowIndex, int columnIndex){ return canEdit[columnIndex];}
		});
		addData(customerTable);
		customerTable.setGridColor(new java.awt.Color(1, 23, 71));
		customerTable.setSelectionBackground(new java.awt.Color(230, 238, 255));
		customerTable.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane = new JScrollPane(customerTable);
		scrollPane.setBounds(29,(height/4+29),width - 58,height/2);

		retrieveLabel = new JLabel();
		retrieveLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		retrieveLabel.setForeground(new Color(1, 23, 71));
		retrieveLabel.setText("Retrieve Customer");
		retrieveLabel.setHorizontalTextPosition(JLabel.CENTER);

		backButton = new JButton();
		backButton.setText("Back");
		backButton.setForeground(Color.white);
		backButton.setBackground(new Color(1, 23, 71));
		backButton.addMouseListener(new backListener());

		refresh = new JButton();
		refresh.addMouseListener(new refreshListener());
		refresh.setForeground(Color.white);
		refresh.setBackground(new Color(1, 23, 71));
		refresh.setText("Refresh");

		retrieveButton = new JButton();
		retrieveButton.addMouseListener(new retrieveListener());
		retrieveButton.setForeground(Color.white);
		retrieveButton.setBackground(new Color(1, 23, 71));
		retrieveButton.setText("Retrieve");

		remove = new JButton();
		remove.addMouseListener(new removeListener());
		remove.setForeground(Color.white);
		remove.setBackground(new Color(1, 23, 71));
		remove.setText("Remove");

		newCust = new JButton();
		newCust.addMouseListener(new addListener());
		newCust.setForeground(Color.white);
		newCust.setBackground(new Color(1, 23, 71));
		newCust.setText("Add");

		/**
		 *layout manager for panel
		 */
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addGap(29, 29, 29)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(remove)
												.addGap(33, 33, 33)
												.addComponent(newCust)
												.addGap(33, 33, 33)
												.addComponent(refresh)
												.addGap(33, 33, 33)
												.addComponent(backButton))
												.addComponent(retrieveButton)))
												.addGap(33, 33, 33)
										.addComponent(scrollPane)
										.addGroup(layout.createSequentialGroup()
												.addComponent(retrieveLabel)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
												)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(remove)
										.addComponent(retrieveLabel)
										.addComponent(remove)
										.addComponent(newCust)
										.addComponent(retrieveButton)
										.addComponent(refresh))
								.addGap(18, 18, 18)
								.addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
												.addComponent(backButton)
												.addGap(22, 22, 22))))
		);
	}

	/**
	 * back button listener, will send GUI back to last panel
	 */
	class backListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			f.setLastPanel(lastPanel);
			f.getLastPanel().setVisible(true);
			f.remove(f.getCurrentPanel());
			f.setCurrentPanel(lastPanel);
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}

	/**
	 * retrieve button listener, will retrieve customer details from selected row or if no row selected sends error message
	 */
	class retrieveListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = customerTable.getSelectedRow();
			if(row == -1){
				JOptionPane.showMessageDialog(f.getCurrentPanel(), "No row selected", "BAPERS", JOptionPane.ERROR_MESSAGE);
			} else {
				String customerData[];
				if(!(customerTable.getValueAt(row,6) == null)) {
					customerData = new String[] {customerTable.getValueAt(row, 0).toString(), customerTable.getValueAt(row, 1).toString(), customerTable.getValueAt(row, 2).toString(), customerTable.getValueAt(row, 3).toString(), customerTable.getValueAt(row, 4).toString(), customerTable.getValueAt(row, 6).toString()};
				} else {
					customerData = new String[] {customerTable.getValueAt(row, 0).toString(), customerTable.getValueAt(row, 1).toString(), customerTable.getValueAt(row, 2).toString(), customerTable.getValueAt(row, 3).toString(), customerTable.getValueAt(row, 4).toString(), null};
				}
				if (customerData[4].equals("Valued")) {
					f.valuedCustomer(customerData);
				} else {
					f.regularCustomer(customerData);
				}
				setVisible(false);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}

	/**
	 * refresh button listener, will update data in table to latest version
	 */
	class refreshListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			DefaultTableModel model = (DefaultTableModel)customerTable.getModel();
			model.setRowCount(0);
			addData(customerTable);
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}

	/**
	 * remove button listener, will remove an entry from the table
	 */
	class removeListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = customerTable.getSelectedRow();
			if(row == -1){
				JOptionPane.showMessageDialog(f.getCurrentPanel(), "No row selected", "BAPERS", JOptionPane.ERROR_MESSAGE);
			} else {
				cT.removeCustomer(Integer.parseInt(customerTable.getValueAt(row, 1).toString()));
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}

	/**
	 * add customer listener, will send GUI to createNewCustomer
	 */
	class addListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			f.createNewCustomer();
			setVisible(false);
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}

	/**
	 * adds data from customer database to table
	 * @param table
	 */
	private void addData(JTable table){
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0);
		customers = cT.getAllCustomers();
		data = cT.getCustomerData(customers);
		for(String[] a : data){
			model.addRow(new Object[]{a[0], a[1], a[2], a[3], a[4], a[5],a[6]});
		}
		table.setModel(model);
	}

}
package model.database;

import model.admin.alert.Alert;
import model.admin.alert.ScheduledAlert;
import model.admin.alert.transaction.AlertTransaction;
import model.discounts.variable_discount.VariableDiscount;
import model.admin.userAccount.UserAccount;
import model.admin.userAccount.transaction.UserAccountTransaction;
import model.customers.Customer;
import model.customers.transaction.CustomersTransaction;
import model.customers.transaction.I_CustomersTransaction;
import model.discounts.discount.transaction.DiscountTransaction;
import model.discounts.discount.transaction.I_DiscountTransaction;
import model.discounts.fixed_discount.transaction.FixedDiscountTransaction;
import model.discounts.fixed_discount.transaction.I_FixedDiscountTransaction;
import model.discounts.flexible_discount.FlexibleDiscount;
import model.discounts.flexible_discount.transaction.FlexibleDiscountTransaction;
import model.discounts.flexible_discount.transaction.I_FlexibleDiscountTransaction;
import model.discounts.variable_discount.transaction.I_VariableDiscountTransaction;
import model.discounts.variable_discount.transaction.VariableDiscountTransaction;
import model.jobs.card_payment.transaction.Card_payment_Transaction;
import model.jobs.card_payment.transaction.I_Card_payment_Transaction;
import model.jobs.existing_tasks.ExistingTasks;
import model.jobs.existing_tasks.transaction.ExistingTasks_Transaction;
import model.jobs.existing_tasks.transaction.I_ExistingTasks_Transaction;
import model.jobs.job.Job;
import model.jobs.job.transaction.I_Job_Transaction;
import model.jobs.job.transaction.Job_Transaction;
import model.jobs.payment.transaction.I_Payment_Transaction;
import model.jobs.payment.transaction.Payment_Transaction;
import model.jobs.task.Task_List;
import model.jobs.task.transaction.I_Task_Transaction;
import model.jobs.task.transaction.Task_Transaction;
import reports.individual_performance_report.IndividualPerformanceReport;
import reports.individual_performance_report.transaction.I_IndividualPerformanceReport_Transaction;
import reports.individual_performance_report.transaction.IndividualPerformanceReport_Transaction;
import reports.job_performance_report.JobPerformanceReport;
import reports.job_performance_report.transaction.I_JobPerformanceReport_Transaction;
import reports.job_performance_report.transaction.JobPerformanceReport_Transaction;
import reports.summary_performance_report.SummaryPerformanceReport;
import reports.summary_performance_report.transaction.I_SummaryPerformanceReport_Transaction;
import reports.summary_performance_report.transaction.SummaryPerformanceReport_Transaction;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * The main class which acts as a bridge between the database logic and the GUI.
 * Things such as the main DB connection instance, transactions between database and client
 * and schedulers (and their respective thread pools) are stored here.
 */

public class Controller implements I_Bapers {
	private static final DB_Connection mainConn = new DB_Connection();
	private I_FixedDiscountTransaction fixedDiscount = new FixedDiscountTransaction(mainConn);
	private I_FlexibleDiscountTransaction flexibleDiscount = new FlexibleDiscountTransaction(mainConn);
	private I_VariableDiscountTransaction variableDiscount = new VariableDiscountTransaction(mainConn);
	private I_DiscountTransaction discount = new DiscountTransaction(mainConn, fixedDiscount, flexibleDiscount, variableDiscount);
	private I_Job_Transaction job = new Job_Transaction(mainConn);
	private I_Task_Transaction task = new Task_Transaction(mainConn, discount);
	private I_ExistingTasks_Transaction existingTask = new ExistingTasks_Transaction(mainConn);
	private I_Payment_Transaction payment = new Payment_Transaction(mainConn);
	private I_Card_payment_Transaction card_payment = new Card_payment_Transaction(mainConn);
	private I_IndividualPerformanceReport_Transaction individualPerformanceReport = new IndividualPerformanceReport_Transaction(mainConn);
	private I_JobPerformanceReport_Transaction jobPerformanceReport = new JobPerformanceReport_Transaction(mainConn);
	private I_SummaryPerformanceReport_Transaction summaryPerformanceReport = new SummaryPerformanceReport_Transaction(mainConn);
	private I_CustomersTransaction customer = new CustomersTransaction(mainConn);
	private UserAccountTransaction userAccountTransaction = new UserAccountTransaction(mainConn);
	private AlertTransaction alertTransaction = new AlertTransaction(mainConn);
	private UserAccount currentUser;
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	private ArrayList<ScheduledAlert> loadedAlerts = new ArrayList<>();

	public Customer identifyCustomer(int Account_no){
		return (Customer) customer.read(Account_no);
	}

	@Override
	public void createNewCustomer(String name, String company, String address, String phone) {
		customer.addCustomer(name,company, address,phone);
	}

	@Override
	public void updateCustomerDetails(String name, String Company, int Acc_no, String Address, String Phone, String valued){
		customer.updateCustomer(name,Company,Acc_no,Address,Phone, valued);
	}

	public String getDiscountType(int accNo){
		return customer.getDiscountType(accNo);
	}

	@Override
	public ArrayList<String[]> getAllCustomers() {
		return customer.getAllCust();
	}

	@Override
	public String[][] getCustomerData(ArrayList<String[]> customers) {
		return customer.getData(customers);
	}

	@Override
	public boolean removeCustomer(int Acc_no) {
		return customer.remove(Acc_no);
	}

	@Override
	public int getLastAccNo() {
		return customer.getLastAccNo();
	}

	public void backup() {
		// TODO - implement Controller.backup
		throw new UnsupportedOperationException();
	}

	public void restore() {
		// TODO - implement Controller.restore
		throw new UnsupportedOperationException();
	}

	//creates a new job
	public void createJob(int job_ID, String job_desc, String priority, String job_status, int time, String special_instructions, int customer_account_no){
		job.addJob(job_ID, job_desc, priority, job_status, time, special_instructions, customer_account_no);
	}

	//updates the job status
	public void updateJobStatus(int job_ID, String job_status){
		job.updateJobStatus(job_ID, job_status);
	}

	//returns a list of jobs which are not completed
	public ArrayList<Job> getActiveJobs(){
		return job.getActiveJobs();
	}

	//returns a list of jobs(completed or all)
	public ArrayList<Job> getJobs(int customer_id, String type){
		return job.getJobs(customer_id, type);
	}

	//creates a new task
	public void createTask(String existing_task, int Job_ID, String technician, String task_status){
		task.addTask(existing_task, Job_ID, technician, task_status);
	}

	// returns a list of existing task names
	public String[] existingTasks(){
		return task.retrieveExistingTasks();
	}

	//returns a list of technician names
	public String[] retrieveTechnicians(String existing_task){
		return task.retrieveTechnicians(existing_task);
	}

	//returns a list of task associated with a job
	public ArrayList<Task_List> getAllTasks(int job_ID){
		return task.getAllTasks(job_ID);
	}

	//update the task status
	public void updateTaskStatus(int Task_ID, String Task_status){
		task.updateTaskStatus(Task_ID, Task_status);
	}

	//creates a new existing task
	public void createExistingTask(String task_description, double task_price, int task_duration, String department_name){
		existingTask.extendTaskList(task_description, task_price, task_duration, department_name);
	}

	@Override
	public AlertTransaction getAlertTransaction() {
		return alertTransaction;
	}

	//returns a list of existing task with details
	public ArrayList<ExistingTasks> getExistingTasks(){
		return existingTask.getExistingTasks();
	}

	//deletes a existing task
	public void deleteExistingTask(int existing_task_ID){
		existingTask.removeExistingTask(existing_task_ID);
	}

	//updates a existing task
	public void updateExistingTask(int existing_task_ID, String task_name, Double task_price, int task_duration, String department_name){
		existingTask.updateExistingTask(existing_task_ID, task_name, task_price, task_duration, department_name);
	}

	// Gets Job transaction instance
	public I_Job_Transaction getJob() {
		return job;
	}

	//creates a new payment
	public int createPayment(String payment_type, Double payment_amount, Date date, int job_ID){
		return payment.makePayment(payment_amount, payment_type, date, job_ID);
	}

	//generates a invoice
	public String[] generateInvoice(int payment_ID){
		return payment.generateInvoice(payment_ID);
	}

	//creates a new card payment
	public  void createCard_payment(int payment_id, String card_type, String expiry_date, String last_digits, String security_code, double payment_amount, Date date, int job_ID){
		card_payment.makeCard_payment(payment_id, payment_amount, card_type, expiry_date, last_digits, security_code, date, job_ID);
	}

	//generates job sheet
	public ArrayList<JobPerformanceReport> generateJobSheet(LocalDate from_date, LocalDate to_date, int customer_id){
		return jobPerformanceReport.generateJobSheet(from_date, to_date, customer_id);
	}

	//generate individual performance report
	public ArrayList<IndividualPerformanceReport> generateIndividualPerformance_Report(LocalDate from_date, LocalDate to_date){
		return individualPerformanceReport.generateIndividualPerformance_Report(from_date, to_date);
	}

	//generated summary performance report
	public ArrayList<SummaryPerformanceReport> generateSummaryPerformanceReport(LocalDate from_date, LocalDate to_date, LocalTime from_time, LocalTime to_time){
		return summaryPerformanceReport.generateSummaryPerformanceReport(from_date, to_date, from_time, to_time);
	}

	@Override
	public ArrayList<ScheduledAlert> getLoadedAlerts() {
		return loadedAlerts;
	}

	@Override
	public void removeAlert(Alert alert) {
		alertTransaction.remove(alert.getId());
	}

	@Override
	public void refreshAllAlerts(JFrame parent) {
		for (ScheduledAlert scheduledAlert : loadedAlerts) {
			scheduledAlert.cancelSchedule();
		}
		loadedAlerts.clear();
		loadAllAlerts(parent);
	}

	/**
	 * Loads all alerts into the system.
	 * Runs:
	 * 	On GUI load
	 * 	When Refresh Alerts is clicked
	 * 	On creation of Jobs and Payments.
	 * @param parent Takes a parent GUI frame to display a Popup box on.
	 */
	@Override
	public void loadAllAlerts(JFrame parent) {
		ArrayList<Alert> alerts = alertTransaction.getAll();
		if (!alerts.isEmpty()) {
			for (Alert alert : alerts) {
				// Create a new shceduledAlert object.
				ScheduledAlert scheduledAlert = new ScheduledAlert(alert, parent, this, mainConn);
				if (scheduledAlert.canRunAlert()) {
					scheduledAlert.runAlert(); // Run the alrt.
				}else{
					System.out.println(alert.toString() + " is most likely already complete.");
					scheduledAlert.removeFromLoadedAlerts(); // Remove the alert if it cannot run.
				}
			}
			// Print all alerts for debugging and convenience in the console
			for (ScheduledAlert scheduledAlert1 : getLoadedAlerts()) {
				System.out.println(scheduledAlert1.toString() + " " + scheduledAlert1.getAlert().getTimeUntilExecutionInSeconds() + "s until execution.");
			}
		}
	}

	@Override
	public ScheduledExecutorService getScheduler() {
		return scheduler;
	}

	/**
	 * Update a Staff Member using a UserAccountTransaction
	 * @param values The values that will be updated from the GUI.
	 * @return A boolean value which reflects the success of the action.
	 */
	@Override
	public boolean updateStaffMember(Object[] values) {
		try {
			// Lengths are checked to see if a customer is a technician.
			// If a customer is a technician, they will have one more argument.
			if (values.length == 6) {
				userAccountTransaction.update(
						(int) values[0], (String) values[1],
						(String) values[2], (String) values[3],
						(String) values[4], (String) values[5]
				);
			}else if (values.length == 7) {
				userAccountTransaction.update(
						(int) values[0], (String) values[1],
						(String) values[2], (String) values[3],
						(String) values[4], (String) values[5],
						(String) values[6]
				);
			}
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Adds a Staff Member using a UserAccountTransaction.
	 * @param values The values that will be added from the GUI.
	 * @return A boolean value which reflects the success of the action.
	 */
	@Override
	public boolean addStaffMember(String[] values) {
		//TODO: Add verification
		try {
			if (values.length == 5) {
				userAccountTransaction.create(values[0], values[1], values[2], values[3], values[4]);
			}else if (values.length == 6) {
				userAccountTransaction.create(values[0], values[1], values[2], values[3], values[4], values[5]);
			}
			return true;
		} catch (Exception e) { e.printStackTrace(); }
		return false;
	}

	/**
	 * Removes a Staff Member using a UserAccountTransaction.
	 * @param id The id from the GUI for the target Staff Account to be removed.
	 * @return A boolean value which reflects the success of the action.
	 */
	@Override
	public boolean removeStaffMember(int id) {
		try {
			userAccountTransaction.remove(id);
			return true;
		} catch (Exception e) { e.printStackTrace(); }
		return false;
	}

	/**
	 * Populates a table with Staff Account data.
	 * @param table The table which will be populated.
	 */
	@Override
	public void populateStaffTable(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		ArrayList<UserAccount> userAccounts = userAccountTransaction.getAll();
		for (UserAccount act : userAccounts) {
			// Handle Technician differently, as their department needs to be displayed
			if (act.getRole().equals("Technician")) {
				String roleAndDepartment = act.getRole() + " (" + act.getDepartment() + ")";
				model.addRow(new Object[] {
						act.getId(), act.getName(),
						act.getEmail(), act.getPhone(),
						roleAndDepartment
				});
			}else{
				model.addRow(new Object[] {
						act.getId(), act.getName(),
						act.getEmail(), act.getPhone(),
						act.getRole()
				});
			}

		}
	}

	@Override
	public void updateDiscountPlan(int acc_no, String discountPlan) {
		discount.assignDiscountType(acc_no, discountPlan);
	}

	public void addFixedDiscountRate(int customer_acc_no, double discount_rate){
		fixedDiscount.addFixedDiscountRate(customer_acc_no,discount_rate);
	}

	public void removeFlexibleDiscount(int id){
		flexibleDiscount.removeFlexibleDiscount(id);
	}

	public ArrayList<FlexibleDiscount> getAllFlexibleDiscounts(int acc_no) {
		return flexibleDiscount.getFlexibleDiscount(acc_no);
	}

	public void updateFlexibleDiscount(int acc_no,int lowerBound,int UpperBound,double DiscountRate){
		flexibleDiscount.updateFlexibleDiscount(acc_no,lowerBound,UpperBound,DiscountRate);

	}
	public void createFlexibleDiscount(int acc_no,int lowerBound,int UpperBound,double DiscountRate){
		flexibleDiscount.addFlexibleDiscount(acc_no,lowerBound,UpperBound,DiscountRate);
	}

	public ArrayList<FlexibleDiscount> getFlexibleDiscount(int customer_acc_no) {
		return flexibleDiscount.getFlexibleDiscount(customer_acc_no);
	}

	public boolean removeVariableDiscount(int id, int acc_no){
		return variableDiscount.removeVariableDiscount(id,acc_no);
	}
	public ArrayList<VariableDiscount> getAllVariableDiscounts(int acc_no) {
		return variableDiscount.getVariableDiscount(acc_no);
	}

	public void updateVariableDiscount(int acc_no, Double discount_rate, String catalog_name){
		variableDiscount.updateVariableDiscount( acc_no, discount_rate, catalog_name);
	}



	public void createVariableDiscount(int acc_no, Double discount_rate, String catalog_name){
		variableDiscount.addVariableDiscount(acc_no,  discount_rate, catalog_name);
	}

	public ArrayList<VariableDiscount> getVariableDiscount(int customer_acc_no){
		return variableDiscount.getVariableDiscount(customer_acc_no);
	}
	@Override
	public void populateVariableTable(JTable table,int acc_no) {
			double price,newPrice,discount;
			int i=0;
			ArrayList<Integer> catalogId= new ArrayList<Integer>();
			catalogId=variableDiscount.getCatalog_IDs(acc_no);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			ArrayList<VariableDiscount> variableDiscounts =getAllVariableDiscounts(acc_no);

			for (VariableDiscount a : variableDiscounts) {
				//make sure all tasks in catalog are displayed on the table so the user can edit the rates.
				int id = catalogId.get(i);
				price= variableDiscount.GetTaskPrice(id);
				newPrice=variableDiscount.calculateNewPrice(a.getDiscount_rate(),price);
				model.addRow(new Object[] {
						id,variableDiscount.GetTaskName(i),price,a.getDiscount_rate(),newPrice
				});
				i++;
			}
		}
	public ArrayList<String> ManageVariableTable(int acc_no) {
		double price, newPrice, discount;
		int id;
		ArrayList<Integer> catalogId = new ArrayList<Integer>();
		ArrayList<String> TaskNames = new ArrayList<String>();

		catalogId = variableDiscount.getCatalog_IDs(acc_no);

		for (int i = 0; i < catalogId.size(); i++){
			//allows us to check if a task has already assigned a discount
			id = catalogId.get(i);
			TaskNames.add(variableDiscount.GetTaskName(id));
		}
		return TaskNames;
	}

	public String getDiscountRate(int acc_no){

		return String.valueOf(fixedDiscount.getDiscountRate(acc_no));
	}


	@Override
	public UserAccount getCurrentUser() { return currentUser; }

	/**
	 * Authenticate a user if their ID and Password match from the database.
	 * On success, currentUser is set and used throughout the system.
	 * @param id The ID to check.
	 * @param password The password to check.
	 * @return A boolean value reflecting the success of the action.
	 */
	@Override
	public boolean authenticateUser(int id, String password) {
		if (userAccountTransaction.authenticate(id, password) != null) {
			currentUser = userAccountTransaction.authenticate(id, password);
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Removes currentUser reflecting the Logout functionality.
	 */
	@Override
	public void logout() {
		currentUser = null;
	}

	public Controller() { }
}
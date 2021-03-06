package model.jobs.job.transaction;

import model.Transaction;
import model.jobs.job.Job;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Manpreet
 */

public interface I_Job_Transaction extends Transaction {

    /**
     * creates a new job
     *
     * @param job_ID
     * @param job_desc
     * @param priority
     * @param job_status
     * @param time
     * @param special_instructions
     * @param customer_account_no
     */
    void addJob(int job_ID, String job_desc, String priority, String job_status, int time, String special_instructions,  int customer_account_no);

    /**
     * updates the job status
     *
     * @param job_ID
     * @param job_status
     */
    void updateJobStatus(int job_ID, String job_status);

    /**
     * returns the list of all active jobs (not completed)
     *
     * @return
     */
    ArrayList<Job> getActiveJobs();

    //returns the list of jobs associated with the customer
    ArrayList<Job> getJobs(int customer_id, String type);

    public ArrayList<Job> getAll();

}


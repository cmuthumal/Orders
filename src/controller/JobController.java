/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import db.JobDBAccess;
import model.Job;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class JobController {

    private JobDBAccess jobDBAccess;

    public JobController() {
        jobDBAccess = new JobDBAccess();
    }

    public boolean addJob(Job job) throws SQLException, ClassNotFoundException {
        return jobDBAccess.addJob(job);
    }

    public boolean updateJob(Job job) throws SQLException, ClassNotFoundException {
        return jobDBAccess.updateJob(job);
    }

    public boolean deleteJob(int id) throws SQLException, ClassNotFoundException {
        return jobDBAccess.deleteJob(id);
    }

    public ArrayList<Job> getAllJobs() throws SQLException, ClassNotFoundException {
        return jobDBAccess.getAllJobs();
    }

    public ArrayList<Job> searchJob(String key) throws SQLException, ClassNotFoundException {
        return jobDBAccess.searchJob(key);
    }

    public int getNextID() throws SQLException, ClassNotFoundException {
        return jobDBAccess.getNextID();
    }

    public int getTimes(String serialNo) throws SQLException, ClassNotFoundException {
        return jobDBAccess.getTimes(serialNo);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import db.JobDoneDBAccess;
import model.JobDone;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class JobDoneController {

    private JobDoneDBAccess jobDoneDBAccess;

    public JobDoneController() {
        jobDoneDBAccess = new JobDoneDBAccess();
    }

    public boolean addJobDone(JobDone jd) throws SQLException, ClassNotFoundException {
        return jobDoneDBAccess.addJobDone(jd);
    }

    public boolean updateJobDone(JobDone jd) throws SQLException, ClassNotFoundException {
        return jobDoneDBAccess.updateJobDone(jd);
    }

    public boolean deleteJobDone(int id) throws SQLException, ClassNotFoundException {
        return jobDoneDBAccess.deleteJobDone(id);
    }

    public ArrayList<JobDone> getAllJobDone() throws SQLException, ClassNotFoundException {
        return jobDoneDBAccess.getAllJobDone();
    }

    public ArrayList<JobDone> searchJobDone(String key) throws SQLException, ClassNotFoundException {
        return jobDoneDBAccess.searchJobDone(key);
    }

    public int getNextID() throws SQLException, ClassNotFoundException {
        return jobDoneDBAccess.getNextID();
    }
}

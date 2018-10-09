/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Job;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class JobDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean addJob(Job job) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "INSERT INTO Job VALUES ('" + job.getID() + "','" + job.getNoteNo() + "','" + job.getCustomerID() + "','" + job.getDate() + "','" + job.getItemTypeID() + "','" + job.getBrandID() + "'"
                + ",'" + job.getModel() + "','" + job.getSerialNo() + "','" + job.getTimes() + "','" + job.getErrorDesc() + "','" + job.getNotes() + "');";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateJob(Job job) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "UPDATE Job SET noteNo='" + job.getNoteNo() + "' customerID='" + job.getCustomerID() + "', addedDate='" + job.getDate() + "', itemTypeID='" + job.getItemTypeID() + "', "
                + "brand='" + job.getBrandID() + "', model='" + job.getModel() + "', serialNo='" + job.getSerialNo() + "', numOfTimes='" + job.getTimes() + "', "
                + "errorDesc='" + job.getErrorDesc() + "', notes='" + job.getNotes() + "' WHERE id='" + job.getID() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deleteJob(int id) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "DELETE FROM Job WHERE id='" + id + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<Job> getAllJobs() throws ClassNotFoundException, SQLException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM Job WHERE noteNo NOT IN (SELECT noteNo FROM JobDone);";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Job> jobsList = new ArrayList<>();
        while (resultSet.next()) {
            Job j = new Job(resultSet.getInt("id"), resultSet.getString("noteNo"), resultSet.getInt("customerID"), resultSet.getString("addedDate"),
                    resultSet.getInt("itemTypeID"), resultSet.getInt("brandID"), resultSet.getString("model"), resultSet.getString("serialNo"),
                    resultSet.getInt("numOfTimes"), resultSet.getString("errorDesc"), resultSet.getString("notes"));
            jobsList.add(j);
        }
        return jobsList;
    }

    public ArrayList<Job> searchJob(String key) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM Job WHERE noteNo NOT IN (SELECT noteNo FROM JobDone) AND noteNo LIKE '%" + key + "%';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Job> jobsList = new ArrayList<>();
        while (resultSet.next()) {
            Job j = new Job(resultSet.getInt("id"), resultSet.getString("noteNo"), resultSet.getInt("customerID"), resultSet.getString("addedDate"),
                    resultSet.getInt("itemTypeID"), resultSet.getInt("brandID"), resultSet.getString("model"), resultSet.getString("serialNo"),
                    resultSet.getInt("numOfTimes"), resultSet.getString("errorDesc"), resultSet.getString("notes"));

            if (!available(jobsList, j.getNoteNo())) {
                jobsList.add(j);
            }
        }

        sql = "SELECT * FROM Job WHERE noteNo NOT IN (SELECT noteNo FROM JobDone) AND serialNo LIKE '%" + key + "%';";
        resultSet = stm.executeQuery(sql);

        while (resultSet.next()) {
            Job j = new Job(resultSet.getInt("id"), resultSet.getString("noteNo"), resultSet.getInt("customerID"), resultSet.getString("addedDate"),
                    resultSet.getInt("itemTypeID"), resultSet.getInt("brandID"), resultSet.getString("model"), resultSet.getString("serialNo"),
                    resultSet.getInt("numOfTimes"), resultSet.getString("errorDesc"), resultSet.getString("notes"));
            if (!available(jobsList, j.getNoteNo())) {
                jobsList.add(j);
            }
        }

        sql = "SELECT * FROM Job j JOIN Customer c WHERE c.id=j.customerID AND c.customerName Like '%" + key + "%' AND noteNo NOT IN (SELECT noteNo FROM JobDone);";
//        sql = "SELECT * FROM Job WHERE noteNo NOT IN (SELECT noteNo FROM JobDone) AND serialNo LIKE '%" + key + "%';";
        resultSet = stm.executeQuery(sql);

        while (resultSet.next()) {
            Job j = new Job(resultSet.getInt("id"), resultSet.getString("noteNo"), resultSet.getInt("customerID"), resultSet.getString("addedDate"),
                    resultSet.getInt("itemTypeID"), resultSet.getInt("brandID"), resultSet.getString("model"), resultSet.getString("serialNo"),
                    resultSet.getInt("numOfTimes"), resultSet.getString("errorDesc"), resultSet.getString("notes"));
            if (!available(jobsList, j.getNoteNo())) {
                jobsList.add(j);
            }
        }

        return jobsList;
    }

    public int getNextID() throws SQLException, ClassNotFoundException {
        int id = 0;
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT id FROM Job ORDER BY id DESC LIMIT 1;";
        ResultSet resultSet = stm.executeQuery(sql);

        while (resultSet.next()) {
            id = resultSet.getInt("id");
        }

        return ++id;
    }

    public int getTimes(String serialNo) throws SQLException, ClassNotFoundException {
        int times = 0;
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT id FROM Job WHERE serialNo='" + serialNo + "';";
        ResultSet resultSet = stm.executeQuery(sql);

        while (resultSet.next()) {
            times++;
        }
        return times;
    }

    private boolean available(ArrayList<Job> jobsList, String noteNo) {
        boolean available = false;
        for (int i = 0; i < jobsList.size(); i++) {
            Job job = jobsList.get(i);
            if (noteNo.equals(job.getNoteNo())) {
                available = true;
            }
        }
        return available;
    }
}

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
import model.JobDone;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class JobDoneDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean addJobDone(JobDone jd) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "INSERT INTO JobDone VALUES ('" + jd.getID() + "','" + jd.getNoteNo() + "','" + jd.getDate() + "','"
                + jd.getWarranty() + "','" + jd.getRemarks() + "','" + jd.getCost() + "','" + jd.getSellingPrice() + "','"
                + jd.getTechnicianID() + "');";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateJobDone(JobDone jd) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "UPDATE JobDone SET noteNo='" + jd.getNoteNo() + "', issuedDate='" + jd.getDate() + "', warranty='"
                + jd.getWarranty() + "', remarks='" + jd.getRemarks() + "', cost='" + jd.getCost() + "', sellingPrice='"
                + jd.getSellingPrice() + "',technicianID=" + jd.getTechnicianID() + "+ WHERE id='" + jd.getID() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deleteJobDone(int id) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "DELETE FROM JobDone WHERE id='" + id + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<JobDone> getAllJobDone() throws ClassNotFoundException, SQLException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM JobDone";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<JobDone> jdList = new ArrayList<>();
        while (resultSet.next()) {
            JobDone jd = new JobDone(resultSet.getInt("id"), resultSet.getString("noteNo"), resultSet.getString("issuedDate"), resultSet.getInt("warranty"), resultSet.getString("remarks"), resultSet.getDouble("cost"), resultSet.getDouble("sellingPrice"), resultSet.getInt("technicianID"));
            jdList.add(jd);
        }
        return jdList;
    }

    public ArrayList<JobDone> searchJobDone(String key) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM JobDone WHERE noteNo LIKE '%" + key + "%';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<JobDone> jdList = new ArrayList<>();
        while (resultSet.next()) {
            JobDone jd = new JobDone(resultSet.getInt("id"), resultSet.getString("noteNo"), resultSet.getString("issuedDate"), resultSet.getInt("warranty"), resultSet.getString("remarks"), resultSet.getDouble("cost"), resultSet.getDouble("sellingPrice"), resultSet.getInt("technicianID"));
            jdList.add(jd);
        }
        return jdList;
    }

    public int getNextID() throws SQLException, ClassNotFoundException {
        int id = 0;
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT id FROM JobDone ORDER BY id DESC LIMIT 1;";
        ResultSet resultSet = stm.executeQuery(sql);

        while (resultSet.next()) {
            id = resultSet.getInt("id");
        }

        return ++id;
    }
}

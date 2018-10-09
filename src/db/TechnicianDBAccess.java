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
import model.Technician;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class TechnicianDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean addTechnician(Technician tech) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "INSERT INTO Technician VALUES ('" + tech.getID() + "','" + tech.getName() + "');";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateTechnician(Technician tech) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "UPDATE Technician SET technicianName='" + tech.getName() + "' WHERE id='" + tech.getID() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deleteTechnician(int id) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "DELETE FROM Technician WHERE id='" + id + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<Technician> getAllTechnicians() throws ClassNotFoundException, SQLException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM Technician;";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Technician> techniciansList = new ArrayList<>();
        while (resultSet.next()) {
            Technician technician = new Technician(resultSet.getInt("id"), resultSet.getString("technicianName"));
            techniciansList.add(technician);
        }
        return techniciansList;
    }

    public ArrayList<Technician> searchTechnician(String key) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM Technician WHERE technicianName LIKE '%" + key + "%';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Technician> techniciansList = new ArrayList<>();
        while (resultSet.next()) {
            Technician technician = new Technician(resultSet.getInt("id"), resultSet.getString("technicianName"));
            techniciansList.add(technician);
        }
        return techniciansList;
    }

    public int getNextID() throws SQLException, ClassNotFoundException {
        int id = 0;
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT id FROM Technician ORDER BY id DESC LIMIT 1;";
        ResultSet resultSet = stm.executeQuery(sql);

        while (resultSet.next()) {
            id = resultSet.getInt("id");
        }

        return ++id;
    }
}

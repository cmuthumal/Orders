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
import model.Customer;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class CustomerDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean addCustomer(Customer c) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "INSERT INTO Customer VALUES ('" + c.getID() + "','" + c.getName() + "','" + c.getPhone() + "','" + c.getAddress() + "');";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateCustomer(Customer c) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "UPDATE Customer SET customerName='" + c.getName() + "', phone='" + c.getPhone() + "', customerAddress='" + c.getAddress() + "' WHERE id='" + c.getID() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deleteCustomer(int id) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "DELETE FROM Customer WHERE id='" + id + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM Customer;";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Customer> customersList = new ArrayList<>();
        while (resultSet.next()) {
            Customer customer = new Customer(resultSet.getInt("id"), resultSet.getString("customerName"), resultSet.getInt("phone"), resultSet.getString("customerAddress"));
            customersList.add(customer);
        }
        return customersList;
    }

    public ArrayList<Customer> searchCustomer(String key) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM Customer WHERE customerName LIKE '" + key + "%';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Customer> customersList = new ArrayList<>();
        while (resultSet.next()) {
            Customer customer = new Customer(resultSet.getInt("id"), resultSet.getString("customerName"), resultSet.getInt("phone"), resultSet.getString("customerAddress"));
            customersList.add(customer);
        }
        return customersList;
    }

    public String getCustomerName(int id) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM Customer WHERE id='" + id + "';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Customer> customersList = new ArrayList<>();
        while (resultSet.next()) {
            Customer customer = new Customer(resultSet.getInt("id"), resultSet.getString("customerName"), resultSet.getInt("phone"), resultSet.getString("customerAddress"));
            customersList.add(customer);
        }
        return customersList.get(0).getName();
    }

    public int getNextID() throws SQLException, ClassNotFoundException {
        int id = 0;
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT id FROM Customer ORDER BY id DESC LIMIT 1;";
        ResultSet resultSet = stm.executeQuery(sql);

        while (resultSet.next()) {
            id = resultSet.getInt("id");
        }

        return ++id;
    }
}

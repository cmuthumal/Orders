/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import db.CustomerDBAccess;
import model.Customer;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class CustomerController {

    private CustomerDBAccess customerDBAccess;

    public CustomerController() {
        customerDBAccess = new CustomerDBAccess();
    }

    public boolean addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        return customerDBAccess.addCustomer(customer);
    }

    public boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        return customerDBAccess.updateCustomer(customer);
    }

    public boolean deleteCustomer(int id) throws SQLException, ClassNotFoundException {
        return customerDBAccess.deleteCustomer(id);
    }

    public ArrayList<Customer> getAllCustomers() throws SQLException, ClassNotFoundException {
        return customerDBAccess.getAllCustomers();
    }

    public ArrayList<Customer> searchCustomer(String key) throws SQLException, ClassNotFoundException {
        return customerDBAccess.searchCustomer(key);
    }

    public String getCustomerName(int id) throws SQLException, ClassNotFoundException {
        return customerDBAccess.getCustomerName(id);
    }

    public int getNextID() throws SQLException, ClassNotFoundException {
        return customerDBAccess.getNextID();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import db.ReportDBAccess;
import model.Report;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class ReportController {

    private ReportDBAccess customerDBAccess;

    public ReportController() {
        customerDBAccess = new ReportDBAccess();
    }

    public ArrayList<Report> searchReport(String from, String to, int customerID, String key) throws SQLException, ClassNotFoundException {
        return customerDBAccess.searchReport(from, to, customerID, key);
    }
}

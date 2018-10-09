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
import model.Report;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class ReportDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public ArrayList<Report> searchReport(String from, String to, int customerID, String key) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        String sql = "SELECT j.noteNo,j.customerID,j.addedDate,b.brandName,j.model,j.errorDesc,jd.remarks,jd.issuedDate,jd.warranty,jd.cost,jd.sellingPrice,t.technicianName "
                + "FROM Job j JOIN JobDone jd JOIN Brand b JOIN Technician t "
                + "WHERE j.noteNo=jd.noteNo AND jd.issuedDate>='" + from + "' AND jd.issuedDate<='" + to + "' AND b.id=j.brandID AND jd.technicianID=t.id";

        if (customerID != -1) {
            sql += " AND j.customerID='" + customerID + "'";
        }
        if (!key.equals("")) {
            sql += " AND (b.brandName LIKE '%" + key + "%' OR j.model LIKE '%" + key + "%')";
        }
        sql += ";";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Report> reportsList = new ArrayList<>();
        while (resultSet.next()) {
            Report rep = new Report(resultSet.getString("noteNo"), resultSet.getInt("customerID"), resultSet.getString("addedDate"),
                    resultSet.getString("brandName") + " " + resultSet.getString("model"), resultSet.getString("errorDesc"),
                    resultSet.getString("remarks"), resultSet.getString("issuedDate"), resultSet.getInt("warranty"),
                    resultSet.getDouble("cost"), resultSet.getDouble("sellingPrice"), resultSet.getString("technicianName"));
            if (!reportsList.contains(rep)) {
                reportsList.add(rep);
            }
        }
        return reportsList;
    }
}

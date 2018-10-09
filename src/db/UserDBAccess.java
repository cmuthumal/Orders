/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.User;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class UserDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean getID(int pin) throws ClassNotFoundException, SQLException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT id FROM User WHERE pin=" + pin + ";";
        ResultSet resultSet = stm.executeQuery(sql);
        return resultSet.next();
    }

    public boolean changePIN(User user) throws ClassNotFoundException, SQLException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "UPDATE User SET pin='" + user.getPin() + "' WHERE id='" + user.getID() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import db.UserDBAccess;
import model.User;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class UserController {

    private UserDBAccess userDBAccess;

    public UserController() {
        userDBAccess = new UserDBAccess();
    }

    public boolean getID(int pin) throws SQLException, ClassNotFoundException {
        return userDBAccess.getID(pin);
    }

    public boolean changePIN(User user) throws SQLException, ClassNotFoundException {
        return userDBAccess.changePIN(user);
    }
}

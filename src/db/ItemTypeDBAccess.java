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
import model.ItemType;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class ItemTypeDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean addItemType(ItemType it) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "INSERT INTO ItemType VALUES ('" + it.getID() + "','" + it.getItemType() + "');";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateItemType(ItemType it) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "UPDATE ItemType SET itemType='" + it.getItemType() + "' WHERE id='" + it.getID() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deleteItemType(int id) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "DELETE FROM ItemType WHERE id='" + id + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<ItemType> getAllItemTypes() throws ClassNotFoundException, SQLException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM ItemType;";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<ItemType> itemTypesList = new ArrayList<>();
        while (resultSet.next()) {
            ItemType itemType = new ItemType(resultSet.getInt("id"), resultSet.getString("itemType"));
            itemTypesList.add(itemType);
        }
        return itemTypesList;
    }

    public ArrayList<ItemType> searchItemType(String key) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM ItemType WHERE itemType LIKE '%" + key + "%';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<ItemType> itemTypesList = new ArrayList<>();
        while (resultSet.next()) {
            ItemType itemType = new ItemType(resultSet.getInt("id"), resultSet.getString("itemType"));
            itemTypesList.add(itemType);
        }
        return itemTypesList;
    }

    public int getNextID() throws SQLException, ClassNotFoundException {
        int id = 0;
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT id FROM ItemType ORDER BY id DESC LIMIT 1;";
        ResultSet resultSet = stm.executeQuery(sql);

        while (resultSet.next()) {
            id = resultSet.getInt("id");
        }

        return ++id;
    }

    public String getItemType(int id) throws SQLException, ClassNotFoundException {
        String type = "";
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT itemType FROM ItemType WHERE id='" + id + "' LIMIT 1;";
        ResultSet resultSet = stm.executeQuery(sql);

        while (resultSet.next()) {
            type = resultSet.getString("itemType");
        }

        return type;
    }
}

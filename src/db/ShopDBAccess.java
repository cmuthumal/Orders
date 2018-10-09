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
import model.Shop;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class ShopDBAccess {
    
    private Connection connection = null;
    private Statement stm = null;
    
    public Shop getShopDetails() throws ClassNotFoundException, SQLException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();
        
        String sql = "SELECT * FROM Shop LIMIT 1;";
        ResultSet resultSet = stm.executeQuery(sql);
        
        ArrayList<Shop> shopsList = new ArrayList<>();
        while (resultSet.next()) {
            Shop s = new Shop(resultSet.getInt("id"), resultSet.getString("shopName"), resultSet.getString("shopAddress"), resultSet.getString("contact"));
            shopsList.add(s);
        }
        return shopsList.get(0);
    }
}

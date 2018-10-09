/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import db.ShopDBAccess;
import model.Shop;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class ShopController {

    private ShopDBAccess shopDBAccess;

    public ShopController() {
        shopDBAccess = new ShopDBAccess();
    }

    public Shop getShopDetails() throws ClassNotFoundException, SQLException {
        return shopDBAccess.getShopDetails();
    }
}

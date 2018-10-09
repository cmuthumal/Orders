/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import db.ItemTypeDBAccess;
import model.ItemType;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class ItemTypeController {

    private ItemTypeDBAccess itemTypeDBAccess;

    public ItemTypeController() {
        itemTypeDBAccess = new ItemTypeDBAccess();
    }

    public boolean addItemType(ItemType itemType) throws SQLException, ClassNotFoundException {
        return itemTypeDBAccess.addItemType(itemType);
    }

    public boolean updateItemType(ItemType itemType) throws SQLException, ClassNotFoundException {
        return itemTypeDBAccess.updateItemType(itemType);
    }

    public boolean deleteItemType(int id) throws SQLException, ClassNotFoundException {
        return itemTypeDBAccess.deleteItemType(id);
    }

    public ArrayList<ItemType> getAllItemTypes() throws SQLException, ClassNotFoundException {
        return itemTypeDBAccess.getAllItemTypes();
    }

    public ArrayList<ItemType> searchItemType(String key) throws SQLException, ClassNotFoundException {
        return itemTypeDBAccess.searchItemType(key);
    }

    public int getNextID() throws SQLException, ClassNotFoundException {
        return itemTypeDBAccess.getNextID();
    }

    public String getItemType(int id) throws SQLException, ClassNotFoundException {
        return itemTypeDBAccess.getItemType(id);
    }
}

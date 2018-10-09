/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import db.BrandDBAccess;
import model.Brand;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class BrandController {

    private BrandDBAccess brandDBAccess;

    public BrandController() {
        brandDBAccess = new BrandDBAccess();
    }

    public boolean addBrand(Brand brand) throws SQLException, ClassNotFoundException {
        return brandDBAccess.addBrand(brand);
    }

    public boolean updateBrand(Brand brand) throws SQLException, ClassNotFoundException {
        return brandDBAccess.updateBrand(brand);
    }

    public boolean deleteBrand(int id) throws SQLException, ClassNotFoundException {
        return brandDBAccess.deleteBrand(id);
    }

    public ArrayList<Brand> getAllBrands() throws SQLException, ClassNotFoundException {
        return brandDBAccess.getAllBrands();
    }

    public ArrayList<Brand> searchBrand(String key) throws SQLException, ClassNotFoundException {
        return brandDBAccess.searchBrand(key);
    }

    public int getNextID() throws SQLException, ClassNotFoundException {
        return brandDBAccess.getNextID();
    }

    public String getBrandNameByID(int id) throws SQLException, ClassNotFoundException {
        return brandDBAccess.getBrandNameByID(id);
    }
}

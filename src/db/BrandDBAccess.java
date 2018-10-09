/*
 * To change this template, choose Tools | Templates
 * and open the template in the edbror.
 */
package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Brand;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class BrandDBAccess {

    private Connection connection = null;
    private Statement stm = null;

    public boolean addBrand(Brand br) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "INSERT INTO Brand VALUES ('" + br.getID() + "','" + br.getBrand() + "');";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean updateBrand(Brand br) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "UPDATE Brand SET brandName='" + br.getBrand() + "' WHERE id='" + br.getID() + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public boolean deleteBrand(int id) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "DELETE FROM Brand WHERE id='" + id + "';";
        int res = stm.executeUpdate(sql);
        return res == 1;
    }

    public ArrayList<Brand> getAllBrands() throws ClassNotFoundException, SQLException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM Brand;";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Brand> brandsList = new ArrayList<>();
        while (resultSet.next()) {
            Brand brand = new Brand(resultSet.getInt("id"), resultSet.getString("brandName"));
            brandsList.add(brand);
        }
        return brandsList;
    }

    public ArrayList<Brand> searchBrand(String key) throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT * FROM Brand WHERE brandName LIKE '%" + key + "%';";
        ResultSet resultSet = stm.executeQuery(sql);

        ArrayList<Brand> brandsList = new ArrayList<>();
        while (resultSet.next()) {
            Brand brand = new Brand(resultSet.getInt("id"), resultSet.getString("brandName"));
            brandsList.add(brand);
        }
        return brandsList;
    }

    public int getNextID() throws SQLException, ClassNotFoundException {
        int id = 0;
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT id FROM Brand ORDER BY id DESC LIMIT 1;";
        ResultSet resultSet = stm.executeQuery(sql);

        while (resultSet.next()) {
            id = resultSet.getInt("id");
        }

        return ++id;
    }

    public String getBrandNameByID(int id) throws SQLException, ClassNotFoundException {
        String name = "";
        connection = DBConnection.getConnection();
        stm = connection.createStatement();

        String sql = "SELECT brandName FROM Brand WHERE id='" + id + "' LIMIT 1;";
        ResultSet resultSet = stm.executeQuery(sql);

        while (resultSet.next()) {
            name = resultSet.getString("brandName");
        }

        return name;
    }
}

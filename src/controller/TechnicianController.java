/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import db.TechnicianDBAccess;
import model.Technician;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class TechnicianController {

    private TechnicianDBAccess technicianDBAccess;

    public TechnicianController() {
        technicianDBAccess = new TechnicianDBAccess();
    }

    public boolean addTechnician(Technician technician) throws SQLException, ClassNotFoundException {
        return technicianDBAccess.addTechnician(technician);
    }

    public boolean updateTechnician(Technician technician) throws SQLException, ClassNotFoundException {
        return technicianDBAccess.updateTechnician(technician);
    }

    public boolean deleteTechnician(int id) throws SQLException, ClassNotFoundException {
        return technicianDBAccess.deleteTechnician(id);
    }

    public ArrayList<Technician> getAllTechnicians() throws SQLException, ClassNotFoundException {
        return technicianDBAccess.getAllTechnicians();
    }

    public ArrayList<Technician> searchTechnician(String key) throws SQLException, ClassNotFoundException {
        return technicianDBAccess.searchTechnician(key);
    }

    public int getNextID() throws SQLException, ClassNotFoundException {
        return technicianDBAccess.getNextID();
    }
}

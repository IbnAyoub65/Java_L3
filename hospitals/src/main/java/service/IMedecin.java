package service;

import models.Medecin;

import java.sql.SQLException;
import java.util.List;


public interface IMedecin {

    public Medecin add(Medecin medecin) throws SQLException;
    public Medecin update(Medecin medecin,int type) throws SQLException;
    public Medecin findByName(String name) throws SQLException;
    public List<Medecin> findAll() throws SQLException;
    public void delete(String name);
}

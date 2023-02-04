package service;

import models.Medecin;
import models.Service;
import models.Specialite;
import utils.DataBaseHelper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class MedecinDao implements IMedecin {
    Medecin medecin;
    DataBaseHelper db;
    Service service;
    Specialite specialite;

    public MedecinDao(){
        db = new DataBaseHelper();
    }

    @Override
    public Medecin add(Medecin medecin) throws SQLException {
        try{
            String sql="INSERT INTO Medecin VALUES(null,?,?,?,?,?,?,?)";
            db.myPreparStatement(sql);
            Object[] parameters={medecin.getNomCOmplet(),medecin.getDateNaissance(),medecin.getDateEmbauche(),
            medecin.getSalaire(),medecin.getAdresse(),medecin.getSpecialite(),medecin.getService()};
            db.addParameters(parameters);
            db.myExecuteUpdate();
            medecin.setId(db.getGenerateId());
            return medecin;
        }catch(Exception e){
            throw e;

        }
    }

    @Override
    public Medecin update(Medecin medecin, int type) throws SQLException {
        try {
            String sql = type == 0 ?"UPDATE Medecin SET nomComplet=? , dateNaissance=?, dateEmbauche=? , salaire=? , adresse=? , specialite=? , service=? WHERE Medecin.id=?"
                    :"INSERT INTO Medecin VALUES(null,?,?,?,?,?,?,?)";
            db.myPreparStatement(sql);
            Object[] parameters = null;
            if (type == 0) {
                parameters = new Object[8];
                parameters[0] = medecin.getNomCOmplet().toLowerCase();
                parameters[1] = medecin.getDateNaissance().toLowerCase();
                parameters[2] = medecin.getDateEmbauche().toLowerCase();
                parameters[3] = medecin.getSalaire();
                parameters[4] = medecin.getAdresse().toLowerCase();
                parameters[5] = medecin.getSpecialite().getId();
                parameters[6] = medecin.getService().getId();
                parameters[7] = medecin.getId();

            } else {
                parameters = new Object[7];
                parameters[0] = medecin.getNomCOmplet().toLowerCase();
                parameters[1] = medecin.getDateNaissance().toLowerCase();
                parameters[2] = medecin.getDateEmbauche().toLowerCase();
                parameters[3] = medecin.getSalaire();
                parameters[4] = medecin.getAdresse().toLowerCase();
                parameters[5] = medecin.getSpecialite().getId();
                parameters[6] = medecin.getService().getId();
                medecin.setId(db.getGenerateId());
            }

            db.addParameters(parameters);
            db.myExecuteUpdate();
            return medecin;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Medecin findByName(String name) throws SQLException {
        try {
            String sql="SELECT * FROM Medecin WHERE nomComplet=?";
            db.myPreparStatement(sql);
            db.addParameters(new Object[]{name});
            ResultSet rs= db.myExecuteQuery();
            Medecin medecin = null;
            if (rs.next()) {
                 medecin = new Medecin(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8));

            }
            rs.close();
            return (Medecin) medecin;
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<Medecin> findAll() throws SQLException {
        try {
            String sql="SELECT * FROM Medecin WHERE nomComplet=?,dateNaissance=?,dateEmbauche=?,adresse=?";
            db.myPreparStatement(sql);
            ResultSet rs= db.myExecuteQuery();
            List<Medecin> medecins = new ArrayList<>();
            if (rs.next()) {
               /* LocalDate dateNaiss = getLocalDate(rs,"dateNaissance");
                LocalDate dateEmb = getLocalDate(rs,"dateEmbauche");*/
                medecin = new Medecin(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6));
                medecins.add(medecin);
            }
            rs.close();
            return  medecins;
        }
        catch (Exception e){
            throw e;
        }
    }
 static public LocalDate getLocalDate(ResultSet rs, String columnName) throws SQLException {
        Date sqlDate = rs.getDate(columnName);
        return sqlDate == null ? null : sqlDate.toLocalDate();
    }
    @Override
    public void delete(String name) {

    }
}

package models;

import service.ServiceDao;
import service.SpecialiteDao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Medecin {

    private int id;
    private String nomComplet;
    private String dateNaissance;
    private String dateEmbauche;
    private int salaire;
    private String adresse;
    private Specialite specialite;
    private Service service;




    public Medecin(int id, String nomComplet, String dateNaissance, String dateEmbauche, int salaire, String adresse) {
        this.id = id;
        this.nomComplet = nomComplet;
        this.dateNaissance = dateNaissance;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
        this.adresse = adresse;
    }

    public Medecin() {

    }

    public Medecin(int id, String nomComplet, String dateNaissance, String dateEmbauche, int salaire, String adresse, Specialite specialite, Service service) {
        this.id = id;
        this.nomComplet = nomComplet;
        this.dateNaissance = dateNaissance;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
        this.adresse = adresse;
        this.specialite = specialite;
        this.service = service;
    }

    public Medecin(int anInt, String string, String string1, String string2, int anInt1, String string3, int anInt2, int anInt3) {
    }

   /* public void saisi() throws SQLException {
        Medecin medecin = new Medecin();
        Service service = new Service();
        Specialite specialite = new Specialite();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println(" nom du Medecin");
            medecin.setNomCOmplet(sc.next());
            System.out.println(" date naissance");
            medecin.setDateNaissance(sc.next());
            System.out.println("date d'embauche");
            medecin.setDateEmbauche(sc.next());
            System.out.println("salaire");
            medecin.setSalaire(sc.nextInt());
            System.out.println("adresse");
            medecin.setAdresse(sc.next());
            System.out.println("Specialite");
            SpecialiteDao specialiteDao = new SpecialiteDao();
            specialiteDao.findAll().forEach(sp->System.out.println(sp.getId() + ": " + sp.getLibelle()));
            specialite.setId(sc.nextInt());
            medecin.setSpecialite(specialite);
            System.out.println("Service");
            ServiceDao serviceDao = new ServiceDao();
            serviceDao.findAll().forEach(sp->System.out.println(sp.getId() + ": " + sp.getLibelle()));
            service.setId(sc.nextInt());;
            medecin.setService(service);
        }while(medecin.getAdresse().isEmpty());
    }*/

  /*  public void saisiDate(String name){
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Saisir la date");
        do{
            dateNaissance = sc1.next(LocalDate.parse(name, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
             dateEmbauche = LocalDate.parse(name, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        }while(adresse.isEmpty());

    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomCOmplet() {
        return nomComplet;
    }

    public void setNomCOmplet(String nomCOmplet) {
        this.nomComplet = nomCOmplet;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}

package views;

import models.Medecin;
import models.Service;
import models.Specialite;
import service.MedecinDao;
import service.ServiceDao;
import service.SpecialiteDao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Scanner;

public class MedecinView implements Serializable {
    Scanner sc = new Scanner(System.in);
    Medecin medecin = new Medecin();
    Service service = new Service();
    Specialite specialite = new Specialite();
    public void menuMedecin()  throws SQLException {
        int choix;
        do{
            System.out.println("======= Menu Medecin =======");
            System.out.println("1-Ajouter");
            System.out.println("2-Modifier");
            System.out.println("3-Rechercher");
            System.out.println("4-Supprimer");
            System.out.println("5-lister");
            System.out.println("6-Quitter");
            choix = sc.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("======= Ajout de Medecin ======");

                    Scanner sc1 = new Scanner(System.in);

                    System.out.println(" nom du Medecin");
                    medecin.setNomCOmplet(sc1.next());
                    System.out.println(" date naissance");
                    medecin.setDateNaissance(sc1.next());
                    System.out.println("date d'embauche");
                    medecin.setDateEmbauche(sc1.next());
                    System.out.println("salaire");
                    medecin.setSalaire(sc1.nextInt());
                    System.out.println("adresse");
                    medecin.setAdresse(sc1.next());
                    System.out.println("specialite");
                    SpecialiteDao specialiteDao = new SpecialiteDao();
                    specialiteDao.findAll().forEach(sp->System.out.println(sp.getId() + ": " + sp.getLibelle()));
                    specialite.setId(sc1.nextInt());
                    medecin.setSpecialite(specialite);
                    System.out.println("service");
                    ServiceDao serviceDao = new ServiceDao();
                    serviceDao.findAll().forEach(sp->System.out.println(sp.getId() + ": " + sp.getLibelle()));
                    service.setId(sc1.nextInt());;
                    medecin.setService(service);
                    MedecinDao medecinDao = new MedecinDao();
                    if (medecinDao.findByName(medecin.getNomCOmplet()) == null) {

                        medecinDao.update(medecin,1);
                    } else {
                        System.out.println(" le medecin existe déjà");

                    }
                    break;
                case 2:
                    System.out.println("====== Modification du Medecin ======");
                    Scanner sc2 = new Scanner(System.in);
                    MedecinDao medecinDao1 = new MedecinDao();
                    Medecin medecin1 = medecinDao1.findByName(sc2.next());
                    if(medecin1 != null){
                        System.out.println("=== Modidfier le Medecin ===");
                        System.out.println("Nom");
                        medecin1.setNomCOmplet(sc2.next());
                        System.out.println("Date Naissance");
                        medecin1.setDateNaissance(sc2.next());
                        System.out.println("Date Embauche");
                        medecin1.setDateEmbauche(sc2.next());
                        System.out.println("Salaire");
                        medecin1.setSalaire(sc2.nextInt());
                        System.out.println("Adresse");
                        medecin1.setAdresse(sc2.next());
                        System.out.println("Specialite");
                        SpecialiteDao spc = new SpecialiteDao();
                        spc.findAll().forEach(s->System.out.println(s.getId()+": "+s.getLibelle()));
                        specialite.setId(sc2.nextInt());
                        medecin1.setSpecialite(specialite);
                        System.out.println("Service");
                        ServiceDao srv = new ServiceDao();
                        srv.findAll().forEach(sr->System.out.println(sr.getId()+": " + sr.getLibelle()));
                        service.setId(sc2.nextInt());
                        medecin1.setService(service);
                        medecinDao1.update(medecin1,0);
                    }
                    break;
                default:
                    break;
            }

            }while (choix != 6);

    }

}

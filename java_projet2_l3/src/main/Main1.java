package main;

import models.Personne;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main1 {

    public static void main(String[] args){

        List<Personne> perso = new ArrayList<>();
        perso.add(  new Personne("Raby", 65));
        perso.add(new Personne("Aziz", 45));
        perso.add(new Personne("Dieynaba", 52));
        perso.add(new Personne("Mooha", 25));

        System.out.println("======= Afficher toutes les personnes");
        perso.forEach(p->System.out.println(p));
        System.out.println("======= Afficher  les personnes dont le nom contient la lettre e");
        perso.stream().filter(p->p.getNom().contains("e")).forEach(p-> System.out.println(p));
        System.out.println("======= Afficher  ");
        perso.stream().map(p->p.getNom().substring(0,2) +""+ p.getAge()/2).forEach(p-> System.out.println(p));
        System.out.println("======= Age compris entre X et Y  ");
        perso.stream().filter(p->p.getAge()>=18 && p.getAge()<=40).collect(Collectors.toList()).forEach(p-> System.out.println(p));
        System.out.println("=======   ");
        perso.stream().reduce((p1,p2)-> new Personne(
                p1.getNom() + "," +p2.getNom(),(int) perso.stream().mapToInt(p->p.getAge()).average().getAsDouble())).ifPresent(System.out::println);

     /*   System.out.println("=======   ");
        Comparator<Personne> ascending = (p1,p2)->p1.getAge().compareToInt(p2.getAge());*/
    }



}

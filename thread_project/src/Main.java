import services.Thread1;
import services.Thread2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());
        t1.start();
        t2.start();
      /*  int val;
        Scanner scanner = new Scanner(System.in);
        int i  = (int) (10*Math.random());

      do{

          System.out.println("1-entrer la valeur");
          val = scanner.nextInt();
          if(val != i) {
              System.out.println("valeur incorrecte");
              System.out.println("la valeur qui devrait être saisie est: " +i);
          }else{
              System.out.println("success");
              System.out.println(i);
          }


      }while( val != i);*/
    }

}

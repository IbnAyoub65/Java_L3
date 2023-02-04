package services;

public class Thread2 implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 20; i++){
                System.out.println("Thread2 :" +i);
                Thread.sleep(1000);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

package zad1;

import java.util.Random;

public class Konsument implements Runnable{
    private Bufor b;
    private final int thisThreadNumber;
    private static int threadNumber = 0;
    public Konsument(Bufor b) {
        this.b = b;
        thisThreadNumber = threadNumber++;
    }

    @Override
    public void run() {
        Random r = new Random();
        while(true){
            int toConsume = b.get();
            System.out.println("[Consumer " + thisThreadNumber + "] - Consumed: " + toConsume);
            try {
                Thread.sleep(r.nextInt(200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

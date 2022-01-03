package zad1;

import java.util.Random;
import java.util.concurrent.Callable;

public class Producent implements Runnable {
    private Bufor b;
    private final int thisThreadNumber;
    private static int threadNumber = 0;
    public Producent(Bufor b) {
        this.b = b;
        thisThreadNumber = threadNumber++;
    }


    @Override
    public void run() {
        Random r = new Random();
        while (true){
            int toPutInQueue = r.nextInt(100);
            b.put(toPutInQueue);
            System.out.println("[Producer " + thisThreadNumber + "] - Produced: " + toPutInQueue);
            try {
                Thread.sleep(r.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

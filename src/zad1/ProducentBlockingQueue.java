package zad1;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducentBlockingQueue implements Runnable{
    private ArrayBlockingQueue<Integer> array;
    private final int thisThreadNumber;
    private static int threadNumber = 0;
    public ProducentBlockingQueue(ArrayBlockingQueue array) {
        this.array = array;
        thisThreadNumber = threadNumber++;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true){
            int toPutInQueue = r.nextInt(100);
            try {
                array.put(toPutInQueue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[Producer " + thisThreadNumber + "] - Produced: " + toPutInQueue);
            try {
                Thread.sleep(r.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package zad1;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class KonsumentBlockingQueue implements Runnable{
    private ArrayBlockingQueue<Integer> array;
    private final int thisThreadNumber;
    private static int threadNumber = 0;

    public KonsumentBlockingQueue(ArrayBlockingQueue array) {
        this.array = array;
        thisThreadNumber = threadNumber++;
    }

    @Override
    public void run() {
        Random r = new Random();
        while(true){
            int toConsume = 0;
            try {
                toConsume = array.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[Consumer " + thisThreadNumber + "] - Consuming: " + toConsume);
            try {
                Thread.sleep(r.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
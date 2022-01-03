package zad1;

import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        //a
//        Bufor b = new Bufor(20);
//        ExecutorService producenci = Executors.newFixedThreadPool(5);
//        ExecutorService konsumenci = Executors.newFixedThreadPool(5);
//        for(int i = 0; i < 5; i++){
//            producenci.execute(new Producent(b));
//            konsumenci.execute(new Konsument(b));
//        }
//        try {
//            Thread.sleep(15000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        //b
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(20);
        ExecutorService producenciBlockingQueue = Executors.newFixedThreadPool(5);
        ExecutorService konsumenciBlockingQueue = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5; i++){
            producenciBlockingQueue.execute(new ProducentBlockingQueue(blockingQueue));
            konsumenciBlockingQueue.execute(new KonsumentBlockingQueue(blockingQueue));
        }
        try {
            Thread.sleep(15000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.exit(0);
    }
}

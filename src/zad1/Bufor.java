package zad1;

import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Bufor {
    private Queue<Integer> kolejka;
    private final int size;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public Bufor(int size) {
        kolejka = new LinkedList<>();
        this.size = size;
    }
    public void put(int item){
        lock.lock();
        try {
            if(kolejka.size()==size)
                notFull.await();
            kolejka.add(item);
            notEmpty.signal();
        } catch (InterruptedException e) {
            System.out.println("Queue was interrupted while adding an item.");
        } finally {
            lock.unlock();
        }
    }
    public int get(){
        lock.lock();
        try {
            if(kolejka.size()==0)
                notEmpty.await();
            if(kolejka.size() > 0){
                int toReturn = kolejka.remove();
                notFull.signal();
                return toReturn;
            }
        } catch (InterruptedException e) {
            System.out.println("Queue was interrupted while getting an item.");
        } finally {
            lock.unlock();
        }
        return -1;
    }
}

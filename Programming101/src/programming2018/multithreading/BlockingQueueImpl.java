package programming2018.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueueImpl {

    Queue blockingQueue = new LinkedList();
    int capacity = 10;


    /*BlockingQueueImpl(int capacity){
        this.capacity =capacity;
    }*/

    public synchronized void put(Object e){
        while(blockingQueue.size()==capacity) {
            try {
                wait();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        blockingQueue.add(e);
        notifyAll();
    }

    public synchronized Object take(){
        while(blockingQueue.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object result = blockingQueue.remove();
        notifyAll();
        return result;
    }
}

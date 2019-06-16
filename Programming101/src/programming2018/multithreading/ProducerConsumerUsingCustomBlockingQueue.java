package programming2018.multithreading;


import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerUsingCustomBlockingQueue {

    static QueueBlocking<Integer> queue = new QueueBlocking<>(2);

    public static void main(String args[]){
        Thread producer = new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i = 0; i < 10 ; i++) {
                    try {
                        System.out.println("Produced: "+ i);
                        queue.put(i);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });


        Thread consumer = new Thread(new Runnable(){
            @Override
            public void run(){
                while(true){
                    try {
                        System.out.println("Consumed: "+ queue.take());
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        producer.start();
        consumer.start();
    }

    static class QueueBlocking<T>{
        int capacity;
        Queue<T> queue = new LinkedList<T>();

        QueueBlocking(int capacity){
            this.capacity=capacity;
        }

        synchronized void put(T t) throws InterruptedException {
            while(capacity==queue.size()) {
                    wait();

            }
            queue.add(t);
            notifyAll();

        }

        synchronized T take() throws InterruptedException {
            while(queue.isEmpty()){
                    wait();
            }
            T element = queue.poll();
            notifyAll();
            return element;
        }

    }
}

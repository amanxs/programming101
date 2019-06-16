package programming2018.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerUsingBlockingQueue {

    public static void main(String args[]) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);
        final int capacity = 10;

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < capacity; i++) {
                    try {
                        System.out.println("Produced " + i);
                        queue.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("Consumed " + queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        producer.start();
        consumer.start();
    }
}

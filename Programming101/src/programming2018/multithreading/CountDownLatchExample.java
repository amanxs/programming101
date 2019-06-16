package programming2018.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String args[]){

        //A CountDownLatch is initialized with a given count.
        // This count is decremented by calls to the countDown() method.
        // Threads waiting for this count to reach zero can call one of the await() methods
        CountDownLatch latch = new CountDownLatch(3);

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    //Calling await() blocks the thread until the count reaches zero.
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // After this Thread has called countDown() 3 times on the CountDownLatch,
                    // the waiting Thread is released from the await() call.
                    Thread.sleep(1000);
                    latch.countDown();

                    Thread.sleep(1000);
                    latch.countDown();

                    Thread.sleep(1000);
                    latch.countDown();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}

package programming2018.multithreading;

import java.util.concurrent.Semaphore;

public class Print0OddAndEven {
    /**
     * print series 010203040506.. using multi-threading
     * 1st thread will print only 0 2nd thread will print only even numbers and 3rd thread print only odd numbers.
     */

    static int t = 1, limit = 6;
    static volatile boolean flag = true;

    public static void main(String args[]){
        Semaphore sem = new Semaphore(1);
        MyThread one = new MyThread("Thread_0", sem);
        MyThread two = new MyThread("Thread_odd", sem);
        MyThread third = new MyThread("Thread_even", sem);

        one.start();
        two.start();
        third.start();

    }

    static class MyThread extends Thread{
        Semaphore sem;
        String threadName;

        MyThread(String threadName, Semaphore semaphore){
            sem = semaphore;
            this.threadName = threadName;
        }

        public void run(){

        }
    }
}

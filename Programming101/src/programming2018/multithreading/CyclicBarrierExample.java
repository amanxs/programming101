package programming2018.multithreading;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    /**
     * The java.util.concurrent.CyclicBarrier class is a synchronization mechanism
     * In other words, it is a barrier that all threads must wait at, until all threads reach it, before any of the threads can continue.
     */

    /**
     * When you create a CyclicBarrier you specify how many threads are to wait at it, before releasing them.
     *
     */
    CyclicBarrier barrier = new CyclicBarrier(2);

    public static void main(String args[]) {

    }
}

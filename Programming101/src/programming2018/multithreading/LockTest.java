package programming2018.multithreading;

//Testing Object level lock

/**
 *
 If one method of an object is synchronized and the other isn't, can two different threads run them on the same time?
 Yes. Two threads can execute those two methods simultaneously. Thread can get lock on synchronized method,
 but lock is not necessary to execute non-synchronized method.

 I am sure both methods can run concurrently on the same object,
 because the one which is synchronized will only make use of intrinsic lock of that object & acquire it
 but as non-synchronized method won't make use of the lock, they both can run concurrently.
 */


/*
If the methods are synchronized on the same monitor, then they cannot execute simultaneously in different threads.
When the second thread comes to the monitor entry (the start of the synchronized method in this case),
it will block until the first thread releases the monitor.

The actual state of the blocked thread in this case, as reported by jconsole, will be something like java.lang.Thread.State: WAITING (on object monitor)

Assuming all methods are normal instance methods, then they will share the same monitor when invoked on the same object.
That is, if you had something like:
// Thread 1
A a1 = new A();
a1.m1();

// Thread 2
A a2 = new A();
a2.m2()
then in this case, the second thread will be able to call the method, because it's trying to obtain the implicit monitor of the a2 object,
which is not locked by thread 1. But if thread 2 tried to call a1.m2(), then it would block until thread 1 had finished executing m1().

If you have static methods, then they obtain the explicit monitor of the class itself (A.class in my hypothetical-naming case),
so will not be blocked by any instance method invocations.


Instance and Static Methods: Both synchronized instance methods and synchronized static methods can be executed concurrently
because they are used to lock different Objects.

The "class level lock" is just a regular lock on a different object, namely SomeClass.class. The "object level lock" locks on this.



 */
class LockTest {

    // Sync Method. Will acquire the lock
    public static synchronized void meth1() {
        System.out.println(Thread.currentThread().getName()
                + " is executing method1.");
        try {
            Thread.sleep(1000); // to show some processing, Won't release the
            // lock
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out
                .println(Thread.currentThread().getName() + " ended method1.");
    }

    // No lock is required in this method
    public static void meth2() {
        try {
            Thread.sleep(1);// to let meth1 execute first & acquire the lock
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()
                + " is executing method2.");
        System.out
                .println(Thread.currentThread().getName() + " ended method2.");
    }

    public synchronized void meth3() {
        try {
            Thread.sleep(1);// to let meth1 execute first & acquire the lock
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()
                + " is executing method3.");
        System.out
                .println(Thread.currentThread().getName() + " ended method3.");
    }

    public static void main(String[] args) throws Exception {
        final LockTest oracle = new LockTest();
        final LockTest oracle2 = new LockTest();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                oracle.meth1();

            }
        }, "BigThread");

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                oracle.meth3();

            }
        }, "SmallThread");

        t1.start();
        t2.start();
        t1.join();
        //t2.join();
        System.out.println(t2.getState());
    }
}
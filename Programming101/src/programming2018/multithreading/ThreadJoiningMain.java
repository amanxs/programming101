package programming2018.multithreading;

public class ThreadJoiningMain {
    public static void main (String[] args)
    {

        // creating two threads
        ThreadJoining t1 = new ThreadJoining();
        ThreadJoining t2 = new ThreadJoining();
        ThreadJoining t3 = new ThreadJoining();

        // thread t1 starts
        t1.start();

        // starts second thread after when
        // first thread t1 is died.
        try
        {
            System.out.println("Current Thread: "
                    + Thread.currentThread().getName());
            //t1.join();
        }

        catch(Exception ex)
        {
            System.out.println("Exception has " +
                    "been caught" + ex);
        }

        // t2 starts
        t2.start();

        // starts t3 after when thread t2 is died.
        try
        {
            System.out.println("Current Thread: "
                    + Thread.currentThread().getName());
            //t2.join();
        }

        catch(Exception ex)
        {
            System.out.println("Exception has been" +
                    " caught" + ex);
        }

        t3.start();
    }
}

//In the above example we can see clearly second thread t2 starts after first thread t1 is died
// and t3 will start its execution after second thread t2 is die

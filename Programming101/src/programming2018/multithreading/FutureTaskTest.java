package programming2018.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

    public static void main(String[] args) {

        FutureTask<String> futureTask = new FutureTask<String>(() -> {
            return "running";
        });

        Thread t1 = new Thread(futureTask);

        t1.start();

        try {
           String result =  futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

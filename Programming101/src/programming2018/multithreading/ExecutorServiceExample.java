package programming2018.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(()-> {
            return "hello";
        });

    }
}

package programming2018.jpMorgan;

import java.util.concurrent.*;

public class AdditionAndMultiplicationUsingThreads {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Task task1 = new Task(1,2);
        Future<Integer> result1 = executorService.submit(task1);
        Future<Integer> result2 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 3 + 4;
            }
        });

        int result = result1.get() * result2.get();
    }

    static class Task implements Callable<Integer>{

        Integer i1;
        Integer i2;

        Task(Integer val1, Integer val2){
            i1=val1;
            i2=val2;
        }

        public Integer call() throws Exception{
          return i1 + i2;
        }
    }
}


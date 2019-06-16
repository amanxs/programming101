package programming2018.jpMorgan;

public class PrintEvenOddUsingThreads {
    /**
     * Print even odd numbers using Two threads in natural order
     */

    static int i =1;

    public static void main(String args[]){

        Thread odd = new Thread(new Runnable(){
            @Override
            public void run(){
                while (i < 10) {
                    while (i % 2 == 0){
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Print Odd : " + i);
                    i++;
                    notify();
                }
            }
        });

        Thread even = new Thread(new Runnable(){
            public void run(){
                while (i < 10) {
                    while (i % 2 == 1){
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Print Even : " + i);
                    i++;
                    notify();
                }
            }
        });

        odd.start();
        even.start();
    }



}

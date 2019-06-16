package programming2018.multithreading;

public class PrintEvenOdd {

    static int i = 1;

    public static void main(String args[]){

        final Printer printer = new Printer();

        Thread odd = new Thread(new Runnable() {
            @Override
            public void run() {
                printer.printOdd();
            }
        });

        Thread even = new Thread(new Runnable() {
            @Override
            public void run() {
                printer.printEven();
            }
        });

        odd.start();
        even.start();
    }


    static class Printer{

        public synchronized void printOdd(){
            while(i<10){
                while(i%2 == 0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Print Odd : " + i++);
                notify();

            }
        }

        public synchronized void printEven(){
            while(i<10){
                System.out.println(i);
                while(i%2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Print Even : " + i++);
                notify();
            }
        }

    }

}

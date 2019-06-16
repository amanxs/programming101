package programming2018.multithreading;

public class PrintEvenAndOddNumbersUsingTwoThread {

    public static void main(String args[]){
        Printer print = new Printer();
        Thread t1 = new Thread(new TaskEvenOdd(print, 10, false));
        Thread t2 = new Thread(new TaskEvenOdd(print, 10, true));
        t1.start();
        t2.start();

    }

    static class TaskEvenOdd implements Runnable{
        private int max;
        private Printer print;
        private boolean isEvenNumber;

        TaskEvenOdd(Printer print, int max, boolean isEven){
            this.print = print;
            this.max = max;
            this.isEvenNumber = isEven;
        }
        public void run(){
            int number = isEvenNumber == true ? 2: 1;
            while(number<=max){
                if(isEvenNumber)
                    print.printEven(number);
                else
                    print.printOdd(number);
            }
            number+=2;
        }
    }

    static class Printer{
        boolean isOdd = false;
        synchronized void printEven(int number){
            while (!isOdd){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Even:" + number);
            isOdd = false;
            notifyAll();
        }

        synchronized void printOdd(int number){
            while (isOdd){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Odd:" + number);
            isOdd = true;
            notifyAll();
        }
    }

}

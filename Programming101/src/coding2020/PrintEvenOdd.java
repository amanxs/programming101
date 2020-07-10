package coding2020;//package coding2020;
//
//public class PrintEvenOdd {
//    public  static  int LIMIT = 10;
//    public static void main(String[] args) {
//        Thread t1 = new Thread(new TaskEveOdd());
//        Thread t2 = new Thread(new TaskEveOdd());
//        t1.start();
//        t2.start();
//
//    }
//
//    class TaskEvenOdd implements Runnable{
//        int number = 1;
//        Printer print;
//        boolean isEvenNumber;
//        TaskEvenOdd(Printer print, boolean isEvenNumber){
//            this.print = print;
//            this.isEvenNumber = isEvenNumber;
//        }
//        @Override
//        public void run() {
//        int i = 0;
//        while(number<=LIMIT){
//            if(isEvenNumber){
//                //print even number
//            }
//            else{
//                // print odd number
//            }
//            i+=2;
//        }
//        }
//    }
//
//    class Printer{
//        boolean isOdd;
//        Printer(boolean isOdd){
//            this.isOdd = isOdd;
//        }
//        //
//    }
//}

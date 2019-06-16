package programming2018.multithreading;

public class Shared {

    synchronized void test1(Shared s2){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        s2.test2(this);
    }

    synchronized void test2(Shared s1){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        s1.test1(this);
    }
}

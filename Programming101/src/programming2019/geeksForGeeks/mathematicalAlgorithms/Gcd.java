package programming2019.geeksForGeeks.mathematicalAlgorithms;

public class Gcd {

    public static void main(String[] args) {
        getGcd(60, 25);
        getGcd(60, 3);

    }

    private static int getGcd(int x, int y) {
        if(y==0) {
            System.out.println("GCD for the given pair is : " + x);
            return x;
        }
        return getGcd(y,x%y);
    }
}

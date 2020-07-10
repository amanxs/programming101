package programming2020;

public class Gcd {

    /**
     * Euclidean algorithm
     * @param args
     */
    public static void main(String args[]){
        int gcd = gcd(4, 2);
        System.out.println(gcd);
    }


    /**
     * If n2 does not divide n1 then gcd would be the gcd of n2 and the remainder of n1 divided by n2.
     * Idea : If we subtract smaller number from larger (we reduce larger number),
     * GCD doesn’t change. So if we keep subtracting repeatedly the larger of two, we end up with GCD.
     * @param num1
     * @param num2
     * @return
     */
    private static int gcd(int num1, int num2) {
        if(0==num2)
            return num1;

        return gcd(num2, num1%num2);
    }
}

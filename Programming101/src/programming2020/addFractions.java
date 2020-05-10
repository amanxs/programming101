package programming2020;


public class addFractions {

    public static void main(String args[]){
        addFractions(3,4,5,6);
    }

    /**
     * There are two fractions example: F1 = 3/4 and F2 = 5/6.
     * You need to compute their sum and return the result.
     * @param num1
     * @param den1
     * @param num2
     * @param den2
     * @return
     */
    public static void addFractions(int num1, int den1, int num2, int den2){
        int den = den1*den2;
        int num = num1*den2 + num2*den1;
        int gcd = gcd(num, den);
        num=num/gcd;
        den=den/gcd;
        System.out.println(num+"/"+den);
    }

    private static int gcd(int num1, int num2) {
        if(0==num2)
            return num1;

        return gcd(num2, num1%num2);
    }
}

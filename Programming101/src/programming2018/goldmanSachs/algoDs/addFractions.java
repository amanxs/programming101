package programming2018.goldmanSachs.algoDs;

public class addFractions {
    public static void main(String args[]){

    }

    /**
     * There are two fractions example: F1 = 3/4 and F2 = 5/6. You need to compute their sum and return the result.
     * @param num1
     * @param den1
     * @param num2
     * @param den2
     * @return
     */
    private static int addFractions(int num1, int den1, int num2, int den2){

        int den = den1*den2;
        int div = gcd(den1,den2);
        den = den/div;

        int num =  num1*(den/den1) + num2*(den/den2);
        return lowest(num,den);
    }

    private static int gcd(int a, int b){

        if(a == 0)
            return b;

            return gcd(b%a, a);
    }

    private static int lowest(int num, int den){
        int div = gcd (num, den);
        num = num/div;
        den = den/div;
        return num/den;
    }
}

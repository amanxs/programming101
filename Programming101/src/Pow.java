public class Pow {
    /*
    recursion, power reduction; binary，O(logn)
    1. n is a positive even number, such as n=4, that is, 2^4=2*2*2*2, which can be disassembled as (2*2)^(n/2)
    2. n is a positive odd number, such as n=3, that is, 2^3=2*2*2, which can be disassembled as 2*((2*2)^(n-1/2))
    note:
    when n is a negative number, the  recursion is  1/(myPow(x,-n)),
    but if n is 2^31-1,  the  -n  will overflow, so use -(n+1) to avoid this and then multiply Just once x to maintain we didnt change the number
    */
        public double myPow(double x, int n) {
            if(n==0)return 1.0;
            String s = "";
            if(n<0){
                return 1/(x*myPow(x,-(n+1)));
            }

            if((n&1)==0){//n is even
                return myPow(x*x, n/2);
            }else{//odd
                return x*myPow(x*x,(n-1)/2);
            }

        }

        public double myPowR(double x, int n) {
        if (n == Integer.MIN_VALUE && x > 1) return 0;
        double result = 1.0;
        int power = n;
        if (n < 0) {
            power = -power;
            x = 1 / x;
        }

        while (power != 0) {
            if (power % 2 == 1) {
                result *= x;
            }
            x *= x;
            power /= 2;
        }


            return result;
    }


}

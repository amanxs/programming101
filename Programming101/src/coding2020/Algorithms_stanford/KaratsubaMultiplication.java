package coding2020.Algorithms_stanford;

import java.math.BigInteger;

public class KaratsubaMultiplication {

    private KaratsubaMultiplication() {} // this class cannot be instantiated

    public static BigInteger multiply(BigInteger x, BigInteger y) {
        // cutoff to brute force
        int N = Math.max(x.bitLength(), y.bitLength());
        if (N <= 1) return x.multiply(y);

        // number of bits divided by 2, rounded up
        N = (N / 2) + (N % 2);

        // x = a + 2^N b, y = c + 2^N d
        BigInteger b = x.shiftRight(N);
        BigInteger a = x.subtract(b.shiftLeft(N));
        BigInteger d = y.shiftRight(N);
        BigInteger c = y.subtract(d.shiftLeft(N));

        // compute sub-expressions
        BigInteger ac = multiply(a, c);
        BigInteger bd = multiply(b, d);
        BigInteger abcd = multiply(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2 * N));
    }

    public static void main(String[] args) {
        BigInteger A = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
        BigInteger B = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");
        BigInteger C = A.multiply(B);
        C = multiply(A, B);
        System.out.println(C);
    }

    public static BigInteger multiply_1(BigInteger x, BigInteger y){
        int N = x.bitLength();
        System.out.println(N);
        int arr_x[] = new int[N];
        int arr_y[] = new int[N];

        for(int i =0; i<N; i++){
            int carry =0;
            int inner_sum = 0;
            for (int j = 0; j < y.bitLength(); j++) {
                inner_sum = carry + arr_x[i]*arr_y[j];
                carry = inner_sum / 10;
                inner_sum = inner_sum % 10;
            }

        }
    return x;
    }
}

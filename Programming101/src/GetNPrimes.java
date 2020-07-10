import java.math.BigInteger;

public class GetNPrimes {

    static int primes[] = new int [26];
    public static void main(String[] args) {
        BigInteger prime = BigInteger.valueOf(0);
        BigInteger b = new BigInteger(String.valueOf(1));
        prime = prime.multiply(b);
        prime.mod(b).equals(0);
        for(int i=0; i< 26;i++){
            prime = prime.nextProbablePrime();
            primes[i] = prime.intValue();
            System.out.println(primes[i]);
        }
    }
}

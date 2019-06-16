package programming2019.geeksForGeeks.mathematicalAlgorithms;

public class PrimeCheck {
    public static void main(String[] args) {
        boolean isPrime = false;

        isPrime = isPrime(21);
        System.out.println(isPrime);
        isPrime = isPrime(31);
        System.out.println(isPrime);

        isPrime = isPrime(41);
        System.out.println(isPrime);

        isPrime = isPrime(364253617);
        System.out.println(isPrime);

    }

    private static boolean isPrime(int n) {

        // to check if the number is of the form 6k+1 / 6k-1
        if(n%6 !=1 && n%6!=5){
            return false;
        }

        for (int i = 2; i*i <n ; i++) {
            if(n%i==0)
                return false;
        }

        return true;
    }
}

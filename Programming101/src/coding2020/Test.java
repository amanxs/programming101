package coding2020;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

//        System.out.println(sumOfMultiples(3, 7));
//        System.out.println(sumOfMultiples(4, 12));
//        System.out.println(sumOfMultiples(2, 1000000000));
//        System.out.println(sumOfMultiples(7, 97));//2 1000000000
//        System.out.println(sumOfMultiples(1000000000, 1000000000));
//        System.out.println(sumOfMultiples(2, 1));

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0 ;i< T; i++){
            int n = in.nextInt();
            int k = in.nextInt();
        System.out.println(sumOfMultiples(n, k));
        }

    }

    private static int sumOfMultiples(int n, int k) {
        int sum = k;
        while(k>=n){
            sum += k/n;
            k = k/n + k%n;
        }
        return sum;
    }

}

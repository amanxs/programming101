package programming2018.goldmanSachs.algoDs;

import java.util.Scanner;

public class UglyNumbers {
    public static void main (String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i= 0; i<T ; i++){
            int N = in.nextInt();
            System.out.println(getTheNthUglyNumber(N));

        }

    }
    static int getTheNthUglyNumber(int N){
        int i=1;
        int count =1;
        while(count<N){
            i++;
            if(isUgly(i)==1){
                count++;
            }
        }
        return i;
    }
    static int isUgly(int n){
        n = maxDivide(n,2);
        n = maxDivide(n,3);
        n = maxDivide(n, 5);
        return (n==1) ? 1 : 0;
    }
    // this function divides by greatest divisible power of b
    static int maxDivide(int a , int b){
        while(a%b == 0){
            a = a/b;
        }
        return a;
    }

    static int getNthUglyNumberByDP(int n){
        int ugly[] = new int[n];
        int next2=2;
        int next3 = 3;
        int next5 = 5;
        int next_ugly_no = 1;
        ugly[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for(int i =1; i<n; i++){
            next_ugly_no = Math.min(next2,Math.min(next3, next5));
            ugly[i] = next_ugly_no;
            if(next_ugly_no==next2){
                i2++;
                next2=2*ugly[i2];
            }
            else if(next_ugly_no==next3){
                i3++;
                next3=3*ugly[i3];

            }
            else if(next_ugly_no==next5){
                i5++;
                next5=5*ugly[i5];
            }
        }
        return next_ugly_no;

    }


}

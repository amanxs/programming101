package programming2018.dynamicProgramming;

public class Fibonacci {

        final int MAX = 100;
        final int NIL = -1;

        int fib[] = new int[Integer.MAX_VALUE];

    public static void main(String args[]){

    }

     int fib(int n){

        if(fib[n] == NIL) {
            if (n <= 1)
                fib[n] = n;
            else
                fib[n] = fib(n - 1) + fib(n - 2);
        }
        return fib[n];
    }

}

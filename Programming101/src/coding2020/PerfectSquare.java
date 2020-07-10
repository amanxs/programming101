package coding2020;

public class PerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquareNewtonRhapson(16));
    }

    public static double sqrt(int num){
        double l = 0.00001;
        double x = num;
        double root;
        int count=0;
        while(true){
            count++;
            root = 0.5 * (x + num/x);
            if(Math.abs(root - x) < l) break;

            x = root;
        }
        return root;

    }

    public  static  boolean isPerfectSquareNewtonRhapson(int num){
        double sqrt = sqrt(num);
        System.out.println(sqrt);
        System.out.println(Math.floor(sqrt));
        return (sqrt - Math.floor(sqrt)==0);
    }


        public  static  boolean isPerfectSquareOpt(int num){
        long left = 1;
        long right = (long)Integer.MAX_VALUE;

        while (left <= right)
        {
            long mid = (left + right) / 2;
            long midSqr = mid * mid;
            if (midSqr == num) return true;
            else if (midSqr > num) right = mid - 1;
            else left = mid + 1;
        }
        return false;

    }

    public static boolean isPerfectSquare(int num) {
        int low =1;
        int high = num;
        long x =1;
        int a = (int) x;
        while(low<=high){
            int m = low + (high-low)/2;
            int msq = m*m;
            System.out.println(msq);
            if(msq == num) return true;
            if(num< msq){
                high = m-1;
            }
            else{
                low = m+1;

            }
        }
        return false;
    }

    //     for(int i =1 ; i*i<=num ; i++){
    //         if(i*i==num){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}

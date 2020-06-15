public class Test {
    //100 students
    //99 students 1 missing

    // go in a liner fashion

    //1 2 3 4 100
    //

    //100


    //

    //1 2 3 4 5 = 10
    //5 = n(n+1)/2 =15
    //O(n)
    //sum()
    //

    public static void main(String[] args) {
        int arr[] = {1 ,3 ,4, 5 };
        int n =5;
        //System.out.println(getMissingElement(arr, n));
        System.out.println(getLcm(3));
        //System.out.println(hcf(3,6));
        //System.out.println(calc(5, 1));

     }


    private static int getLcm(int n) {
        int lcm =1;
        for(int i=n; i>0; i--){
            if(lcm%i==0) continue;
            lcm = calc(lcm, i);
        }
        return lcm;
    }

    private static int calc(int i, int j) {
        int h = hcf(i, j);
        int n1 = i/h;
        int n2 = j/h;

        return h*n1*n2;
    }

    private static int hcf(int i, int j) {
        System.out.println("This is i:" + i + "and this is j: "+ j);
        if(i%j==0) return j;

        return hcf(j, i%j);
    }

    private static int getMissingElement(int[] arr, int n) {
        int sum=0;
        for(int e : arr){
            sum +=e;
        }
        int exp = (n*(n+1))/2;

        return exp - sum;
    }

    // number n // 1-n find out which is smallest and evenly divisible by 1-n


    //6 :  90 1 2 3 60<-4/2 30/2<-5 6 -> 60 -> 6 9 -> 18 : 6/3 = 2 9/3 = 3 * H = LCM
    // n=3; 1 2 3 -> 6 -> hcf = h  2h 3h





}

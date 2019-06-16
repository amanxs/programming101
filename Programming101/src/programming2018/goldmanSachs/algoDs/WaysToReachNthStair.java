package programming2018.goldmanSachs.algoDs;

public class WaysToReachNthStair {
    // Returns count of ways to reach
    // n-th stair using 1 or 2 or 3 steps.
    public static int findStep(int n)
    {
        if (n == 1 || n == 0)
            return 1;
        else if (n == 2)
            return 2;

        else
            return findStep(n - 3) +
                    findStep(n - 2) +
                    findStep(n - 1);
    }

    // Driver function
    public static void main(String argc[]){
        int n = 7;
        System.out.println(countWays(4));
    }

    static int stepsDp(int n) {
        int ways[] = new int[n+1];
        ways[0] =1;
        ways[1] = 1;
        ways[2] = 2;
        for (int i = 3; i <=n ; i++) {
            ways[i] = ways[i-1] + ways[i-2] + ways[i-3];
        }
        return  ways[n];
    }

    //Returns count of ways to reach
    // n-th stair using 1 or 2 steps.

    public static int countWays(int n){
        int ways[] = new int[n];
        ways[1] =1;
        ways[2] = 2;
        for (int i = 3; i <=n ; i++) {
            ways[i] = ways[i-1] + ways[i-2];
        }
        return ways[n];
    }

}

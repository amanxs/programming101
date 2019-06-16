package programming2018.goldmanSachs.algoDs;

public class MaxStolenValueFromHouse {
    /**
     * There are n houses build in a line, each of which contains some value in it.
     * A thief is going to steal the maximal value of these houses,
     * but he can’t steal in two adjacent houses because owner of the stolen houses will tell his two neighbour left and right side.
     * What is the maximum stolen value.
     */

    public static void main (String[] args)
    {
        int hval[] = {6, 7, 1, 3, 8, 2, 4};
        int n = hval.length;
        System.out.println("Maximum loot value : " + maxLoot(hval, n));
    }

    static int maxLoot(int arr[], int n){
        return Math.max(maxLoot(arr, n-1), arr[n-1] +maxLoot(arr,n-2));
    }

    static int maxLoot(int arr[]){
        int n = arr.length;
        int DP[] = new int[n+1];

        DP[0] = arr[0];
        DP[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n ; i++) {
            DP[i] = Math.max(arr[i] + DP[i-2], DP[i-1]);
        }

        return DP[n-1];
    }

    static int maxLootSpaceOptimized(int hval[], int n)
    {
        if (n == 0)
            return 0;

        int value1 = hval[0];
        if (n == 1)
            return value1;

        int value2 = Math.max(hval[0], hval[1]);
        if (n == 2)
            return value2;

        // contains maximum stolen value at the end
        int max_val = 0;

        // Fill remaining positions
        for (int i=2; i<n; i++)
        {
            max_val = Math.max(hval[i]+value1, value2);
            value1 = value2;
            value2 = max_val;
        }

        return max_val;
    }
}

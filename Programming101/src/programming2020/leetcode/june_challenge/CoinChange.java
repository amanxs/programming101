package programming2020.leetcode.june_challenge;

import java.util.Arrays;

public class CoinChange {

        static int DP[][];
        public static int change(int amount, int[] coins) {
            int n = coins.length;
            DP = new int[amount+1][n+1];
            //Arrays.fill(DP, -1);
            return change(amount, coins,  n - 1);
        }

        public static int change(int amount, int[] coins, int n) {
            if(amount == 0){
                return 1;
            }
            if(amount < 0) return 0;

            if(n<0 && amount>0) return 0;

            //return change(amount, coins, n-1) + change (amount - coins[n], coins, n);

            if(DP[amount][n] != 0) return DP[amount][n];

            DP[amount][n] = change(amount, coins, n-1) + change (amount - coins[n], coins, n);

            return DP[amount][n];

        }


    // Returns the count of ways we can
    // sum S[0...m-1] coins to get sum n
    static int count( int S[], int m, int n )
    {
        // If n is 0 then there is 1 solution
        // (do not include any coin)
        if (n == 0)
            return 1;

        // If n is less than 0 then no
        // solution exists
        if (n < 0)
            return 0;

        // If there are no coins and n
        // is greater than 0, then no
        // solution exist
        if (m <=0 && n >= 1)
            return 0;

        // count is sum of solutions (i)
        // including S[m-1] (ii) excluding S[m-1]
        return count( S, m - 1, n ) +
                count( S, m, n-S[m-1] );
    }

    // Driver program to test above function
    public static void main(String[] args)
    {
        int arr[] = {1, 2, 5};
        int m = arr.length;
        int A[] = {200, 217, 234, 251, 268, 285, 302, 319, 336, 353, 370, 387, 404, 421, 438, 455, 472, 489, 506, 523, 540, 557, 574, 591, 608, 625, 642, 659, 676, 693, 710, 727, 744, 761, 778, 795, 812, 829, 846, 863, 880, 897, 914, 931, 948, 965, 982, 999, 1016, 1033, 1050, 1067, 1084, 1101, 1118, 1135, 1152, 1169, 1186, 1203, 1220, 1237, 1254, 1271, 1288, 1305, 1322, 1339, 1356, 1373, 1390, 1407, 1424, 1441, 1458, 1475, 1492, 1509, 1526, 1543, 1560, 1577, 1594, 1611, 1628, 1645, 1662, 1679, 1696, 1713, 1730, 1747, 1764, 1781, 1798, 1815, 1832, 1849, 1866, 1883, 1900, 1917, 1934, 1951, 1968, 1985, 2002, 2019, 2036, 2053, 2070, 2087, 2104, 2121, 2138, 2155, 2172, 2189, 2206, 2223, 2240, 2257, 2274, 2291, 2308, 2325, 2342, 2359, 2376, 2393, 2410, 2427, 2444, 2461, 2478, 2495, 2512, 2529, 2546, 2563, 2580, 2597, 2614, 2631, 2648, 2665, 2682, 2699, 2716, 2733, 2750, 2767, 2784, 2801, 2818, 2835, 2852, 2869, 2886, 2903, 2920, 2937, 2954, 2971, 2988, 3005, 3022, 3039, 3056, 3073, 3090, 3107, 3124, 3141, 3158, 3175, 3192, 3209, 3226, 3243, 3260, 3277, 3294, 3311, 3328, 3345, 3362, 3379, 3396, 3413, 3430, 3447, 3464, 3481, 3498, 3515, 3532, 3549, 3566, 3583, 3600, 3617, 3634, 3651, 3668, 3685, 3702, 3719, 3736, 3753, 3770, 3787, 3804, 3821, 3838, 3855, 3872, 3889, 3906, 3923, 3940, 3957, 3974, 3991, 4008, 4025, 4042, 4059, 4076, 4093, 4110, 4127, 4144, 4161, 4178, 4195, 4212, 4229, 4246, 4263, 4280, 4297, 4314, 4331, 4348, 4365, 4382, 4399, 4416, 4433, 4450, 4467, 4484, 4501, 4518, 4535, 4552, 4569, 4586, 4603, 4620, 4637, 4654, 4671, 4688, 4705, 4722, 4739, 4756, 4773, 4790, 4807, 4824, 4841, 4858, 4875, 4892, 4909, 4926, 4943, 4960, 4977, 4994};
        //System.out.println( count(arr, m, 500));
        System.out.println( change(4000, A));
        System.out.println( findWays(A, 4000));



    }

    static int findWays(int[] coins, int sum) {
        // Declaring a 2-D array
        // for storing solutions to subproblems:
        int size = coins.length;
        int[][] arr = new int[size + 1][sum + 1];

        // Initializing first column of array to 1
        // because a sum of 0 can be made
        // in one possible way: {0}
        for(int i = 0; i < size + 1; i++)
            arr[i][0] = 1;

        // Applying the recursive solution:
        for(int i = 1; i < size + 1; i++)
            for(int j = 0; j < sum + 1; j++)
                if(coins[i - 1] > j)  // Cannot pick the highest coin:
                    arr[i][j] = arr[i - 1][j];
                else  // Pick the highest coin:
                    arr[i][j] = arr[i][j - coins[i - 1]] + arr[i - 1][j];

        return arr[size][sum];
    }

    /**
     * 4000
     * [200, 217, 234, 251, 268, 285, 302, 319, 336, 353, 370, 387, 404, 421, 438, 455, 472, 489, 506, 523, 540, 557, 574, 591, 608, 625, 642, 659, 676, 693, 710, 727, 744, 761, 778, 795, 812, 829, 846, 863, 880, 897, 914, 931, 948, 965, 982, 999, 1016, 1033, 1050, 1067, 1084, 1101, 1118, 1135, 1152, 1169, 1186, 1203, 1220, 1237, 1254, 1271, 1288, 1305, 1322, 1339, 1356, 1373, 1390, 1407, 1424, 1441, 1458, 1475, 1492, 1509, 1526, 1543, 1560, 1577, 1594, 1611, 1628, 1645, 1662, 1679, 1696, 1713, 1730, 1747, 1764, 1781, 1798, 1815, 1832, 1849, 1866, 1883, 1900, 1917, 1934, 1951, 1968, 1985, 2002, 2019, 2036, 2053, 2070, 2087, 2104, 2121, 2138, 2155, 2172, 2189, 2206, 2223, 2240, 2257, 2274, 2291, 2308, 2325, 2342, 2359, 2376, 2393, 2410, 2427, 2444, 2461, 2478, 2495, 2512, 2529, 2546, 2563, 2580, 2597, 2614, 2631, 2648, 2665, 2682, 2699, 2716, 2733, 2750, 2767, 2784, 2801, 2818, 2835, 2852, 2869, 2886, 2903, 2920, 2937, 2954, 2971, 2988, 3005, 3022, 3039, 3056, 3073, 3090, 3107, 3124, 3141, 3158, 3175, 3192, 3209, 3226, 3243, 3260, 3277, 3294, 3311, 3328, 3345, 3362, 3379, 3396, 3413, 3430, 3447, 3464, 3481, 3498, 3515, 3532, 3549, 3566, 3583, 3600, 3617, 3634, 3651, 3668, 3685, 3702, 3719, 3736, 3753, 3770, 3787, 3804, 3821, 3838, 3855, 3872, 3889, 3906, 3923, 3940, 3957, 3974, 3991, 4008, 4025, 4042, 4059, 4076, 4093, 4110, 4127, 4144, 4161, 4178, 4195, 4212, 4229, 4246, 4263, 4280, 4297, 4314, 4331, 4348, 4365, 4382, 4399, 4416, 4433, 4450, 4467, 4484, 4501, 4518, 4535, 4552, 4569, 4586, 4603, 4620, 4637, 4654, 4671, 4688, 4705, 4722, 4739, 4756, 4773, 4790, 4807, 4824, 4841, 4858, 4875, 4892, 4909, 4926, 4943, 4960, 4977, 4994]
     */
}

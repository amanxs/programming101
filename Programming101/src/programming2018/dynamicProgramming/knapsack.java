package programming2018.dynamicProgramming;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W
 * to get the maximum total value in the knapsack.
 */
public class knapsack {
    public static void main(String args[]){
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        int n = val.length;
        //_initialize();
        int value = knapsackTopDown(val, wt, W, n);
        System.out.print(value);

    }

    /* Get the ratio of w/v : chose the one with max value : Ex 30/120 > 10/60 : so choose 30/120
       Sort the items on the basis of that ratio and add the items and in th end if the an items exceeds the W limitations
       Then split the item in accordance with the limit of W.

     */

    /** But this approach is not valid fo 0-1 Kanpsack problem.
        Because in the 0-1 knapsack problem u wither keep the element oor u dont.
    */

    /**
     *
     1) Optimal Substructure:
     To consider all subsets of items, there can be two cases for every item:
     (1) the item is included in the optimal subset, (2) not included in the optimal set.
     Therefore, the maximum value that can be obtained from n items is max of following two values.
     1) Maximum value obtained by n-1 items and W weight (excluding nth item).
     2) Value of nth item plus maximum value obtained by n-1 items and W minus weight of the nth item (including nth item).
     If weight of nth item is greater than W, then the nth item cannot be included and case 1 is the only possibility.

     * @param val
     * @param wt
     * @param W
     * @param n
     * @return
     * Following is recursive implementation that simply follows the recursive structure mentioned above.
     */
     static int getMaxValueKnapsack(int val[], int wt[], int W, int n){
        int result = 0;
         // Base case
         if(n == 0 || W == 0)
             return 0;

         /** If weight of the nth item is more than Knapsack capacity W, then
             this item cannot be included in the optimal solution
          */
         if (wt[n-1] > W)
             return getMaxValueKnapsack(val, wt, W, n-1);

         /**
          * Return the maximum of two cases:
           (1) nth item included
           (2) not included
          */
         else return Integer.max
                 (val[n-1] + getMaxValueKnapsack(val, wt, W-wt[n-1], n-1) ,
                         getMaxValueKnapsack(val, wt, W, n-1));

    }

    /**
     * 2) Overlapping Subproblems
     * It should be noted that the above function computes the same subproblems again and again.
     * See the following recursion tree, K(1, 1) is being evaluated twice.
     * Time complexity of this naive recursive solution is exponential (2^n).
     * Since suproblems are evaluated again, this problem has Overlapping Subprolems property.
     * So the 0-1 Knapsack problem has both properties of a dynamic programming problem.
     * Like other typical Dynamic Programming(DP) problems, recomputations of same subproblems can be avoided
     * by constructing a temporary array K[][] in bottom up manner.

     * Following is Dynamic Programming based implementation.
     */
    static int knapsack(int W, int wt[], int val[], int n){
        int k[][] = new int[n+1][W+1];
        int i, w;

        // Build table K[][] in bottom up manner
        for( i = 0; i<n; i++){
            for(w=0; w<W; w++){
                if(i==0 || w==0)
                    k[i][w] = 0;
                else if(wt[i-1]<=w)
                    k[i][w] = Integer.max(val[i-1] + k[i-1][w-wt[i-1]],  k[i-1][w]);
            }
        }

        return 0;
    }

    static int k[][] = new int[100][100];
    /* Function to initialize NIL values in lookup table */
    static void _initialize()
    {
        System.out.print(k[0][0]);
    }

    static int knapsackTopDown(int val[], int wt[], int W, int n){
        if(k[n][W]!= 0)
            return k[n][W];

        int result = 0;
        // Base case
        if(n == 0 || W == 0)
            return 0;

        /** If weight of the nth item is more than Knapsack capacity W, then
         this item cannot be included in the optimal solution
         */
        if (wt[n-1] > W)
            k[n][W] =  getMaxValueKnapsack(val, wt, W, n-1);

        /**
         * Return the maximum of two cases:
         (1) nth item included
         (2) not included
         */
        else k[n][W] =  Integer.max
                (val[n-1] + getMaxValueKnapsack(val, wt, W-wt[n-1], n-1) ,
                        getMaxValueKnapsack(val, wt, W, n-1));

        return k[n][W];

    }

    /*
    In the following recursion tree, K() refers to knapSack().  The two
    parameters indicated in the following recursion tree are n and W.
    The recursion tree is for following sample inputs.
    wt[] = {1, 1, 1}, W = 2, val[] = {10, 20, 30}

                       K(3, 2)         ---------> K(n, W)
                   /            \
                 /                \
            K(2,2)                  K(2,1)
          /       \                  /    \
        /           \              /        \
       K(1,2)      K(1,1)        K(1,1)     K(1,0)
       /  \         /   \          /   \
     /      \     /       \      /       \
K(0,2)  K(0,1)  K(0,1)  K(0,0)  K(0,1)   K(0,0)

    Recursion tree for Knapsack capacity 2 units and 3 items of 1 unit weight.

    */
}

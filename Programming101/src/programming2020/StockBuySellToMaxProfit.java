package programming2020;

/**
 * Stock Buy Sell to Maximize Profit
 The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days.
 For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned by buying on day 0, selling on day 3.
 Again buy on day 4 and sell on day 6. If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
 */
public class StockBuySellToMaxProfit {

    public static void main(String args[]){
        int arr[] = {5,2,3,2,6,6,2,9,1,0,7,4,5,0};

        int maxProfit = getMaxProfit(arr, arr.length);
        System.out.println(maxProfit);
    }

    private static int getMaxProfit(int arr[], int n){
        int buy=0;
        int sell=0;
        int profit = 0;
        if(arr[0]<arr[1]){
            buy = arr[0];
            System.out.println("Buy at : " + 0);

        }
        for(int i=1; i< n-1; i++){
            if(arr[i]<=arr[i-1] && arr[i]<=arr[i+1]){
                buy = arr[i];
                System.out.println("Buy at : " + i);
            }
            if(arr[i]>=arr[i-1] && arr[i]>=arr[i+1]){
                sell = arr[i];
                profit += sell-buy;
                System.out.println("Sell at : " + i + " for a profit of " + profit);

            }
        }
        if(arr[n-1]>arr[n-2]){
            sell = arr[n-1];
            profit += sell-buy;
            System.out.println("Sell at : " + (n-1) + " for a profit of " + profit);

        }

        return profit;
    }

}

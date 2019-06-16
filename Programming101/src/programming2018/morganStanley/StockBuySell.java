package programming2018.morganStanley;

public class StockBuySell {

    public static void main(String args[]){
        int arr[] = {100, 180, 260, 310, 40, 535, 695};


        System.out.println(getMaxProfit(arr,arr.length));
    }

    static int getMaxProfit(int arr[], int n){
        int buy = arr[0];
        int sell =arr[0];
        int profit = 0;

        for (int i = 1; i <n ; i++) {
            sell = Math.max(arr[i], sell);
            if(arr[i]<buy){
                profit += sell-buy;
                buy = arr[i];
            }
        }
        profit = arr[n-1]>buy ? profit + arr[n-1] - buy : profit ;

        return profit;


    }
}

package programming2019.geeksForGeeks.mustDoCodingQuestions.arrays;

public class StockBuyAndSell {
    /**
     * The cost of stock on each day is given in an array A[] of size N.
     * Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.
     */

    public static void main(String[] args) {
        /**
         * Input:
         2
         7
         100 180 260 310 40 535 695
         10
         23 13 25 29 33 19 34 45 65 67
         */

        int arr [] = {100, 180, 260, 310, 40, 535, 695,0};

        int arr2[] = {23, 13, 25, 29, 33, 19, 34, 45, 65, 67, 0};

        getMaxProfit(arr2);
    }

    private static void getMaxProfit(int[] arr) {
        int length = arr.length;
        int buy=arr[0];
        int sell;

        if(isLocalMinima(0, arr[0], arr[1])){
            buy = arr[0];
            System.out.println("Buy at index : " + 0);
        }
        for(int i =1; i< arr.length-1; i++){
            if(isLocalMinima(arr[i-1], arr[i], arr[i+1])){
                buy = arr[i];
                System.out.println("Buy at index: " + i);
            }
            if(isLocalMaxima(arr[i-1], arr[i], arr[i+1])){
                sell =arr[i];
                System.out.println("Sell at index: " + i);

                int profit = sell - buy;

                System.out.println("Profit now at : " + profit);
            }



        }
    }

    private static boolean isLocalMaxima(int left, int element, int right){
        if(element>left && element >right)
            return true;
        return false;
    }

    private static boolean isLocalMinima(int left, int element, int right){
        if(element<left && element <right)
            return true;
        return false;
    }
}

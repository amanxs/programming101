package programming2018.goldmanSachs.algoDs;


public class CountPairsWithGivenSum {
    /**
     * Given an array of integers, and a number ‘n’,
     * find the number of pairs of integers in the array whose sum is equal to ‘n’.
     */

    public static void main(String args[]){
        int arr[] = {1,5,7,-1,5};
        int sum = 6;
        System.out.print(getPairsCount(arr,sum));
    }

    static int getPairCountSimple(int arr[], int sum){
        int pairs=0;
        for(int i=0; i<arr.length-1; i++){
            for (int j = i+1; j < arr.length; j++) {
                if(sum == arr[i]+arr[j]){
                    pairs++;
                }
            }
        }
        return pairs;
    }

    static int getPairsCount(int arr[], int sum){
        java.util.HashMap<Integer,Integer> hm = new java.util.HashMap<>();

        for(int i=0; i<arr.length; i++){
            if(hm.containsKey(arr[i]))
                hm.put(arr[i],hm.get(arr[i])+1);
            else
                hm.put(arr[i],1);//Why is it zero in the programming2018.geeksForGeeks Solution
        }

            int count = 0;
        for(int i=0; i<arr.length; i++){
            if(hm.containsKey(sum-arr[i])){
                count += hm.get(sum-arr[i]);
            }

            if(arr[i]==sum-arr[i]){
                count--;
            }
        }

        return count/2;

    }
}

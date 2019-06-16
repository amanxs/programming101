package programming2019.geeksForGeeks.mustDoCodingQuestions.arrays;

public class PartitionPointInUnsortedArray {

    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 5, 2, 6, 8 ,6 , 7 } ;
        int partition = getPartition(arr);
    }

    private static int getPartition(int[] arr) {

        int leftMax= arr[0];
        int rightMin = arr[0];
        int partition_index = -1;
        for(int i=1; i< arr.length; i++){
            if(arr[i]>leftMax){
                partition_index=i;
                leftMax=arr[i];
            }
        }

        return partition_index;
    }
}

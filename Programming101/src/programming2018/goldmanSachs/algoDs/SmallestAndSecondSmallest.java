package programming2018.goldmanSachs.algoDs;

public class SmallestAndSecondSmallest {

    public static void main(String args[]){

    }

    static void getSmallestAndSecondSmallest(int arr[]){
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        if(arr.length<2) {
            System.out.print("Invalid input");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<smallest){
                secondSmallest=smallest;
                smallest = arr[i];
            }
            else if(arr[i]<secondSmallest && arr[i] != smallest)
                secondSmallest=arr[i];
        }
    }

    static void getLargestAndSecondLargest(int arr[]){
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        if(arr.length<2) {
            System.out.print("Invalid input");
            return;
        }

        for (int i = 0; i < arr.length ; i++) {
            if(arr[i]>first){
                second=first;
                first=arr[i];
            }
            else if(arr[i]>second && arr[i] != first){
                second=arr[i];
            }
        }
        if(second==Integer.MIN_VALUE)
            System.out.print("there is no second largest element");
        else
            System.out.println("The second largest element is :" + second);

    }
}

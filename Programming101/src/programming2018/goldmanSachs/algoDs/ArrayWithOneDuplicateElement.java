package programming2018.goldmanSachs.algoDs;

public class ArrayWithOneDuplicateElement {

    // 5, 4, 1, 7, 3, 1, 6, 2

    public static void main(String args[]){
        int arr[] = new int []{1, 4, 5, 7, 3, 1, 6, 2};
        int dup = getDuplicate(new int[]{5, 2, 3, 5, 1, 4});
        System.out.println(dup);
    }

    // Find duplicate without using extra space.
    // Case 1 : The elements are in the range 1..n
    static int getDuplicate(int arr[]){

        for(int i=0; i<arr.length; i++){
            int element = arr[Math.abs(arr[i])];
            if(element<0)
                return Math.abs(arr[i]); // if asked for the element repeating otherwise we can also return the index.
            else
                arr[Math.abs(arr[i])] = - element;

        }
        return 0;
    }


}

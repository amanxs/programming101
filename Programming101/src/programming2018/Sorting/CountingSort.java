package programming2018.Sorting;

//This does not require the programming2018.Sorting Template as this does not follow the Comparison model
public class CountingSort {

/*Driver program */

    public static void main(String args[]){
    CountingSort cs = new CountingSort();
        int[] a = {3,9,3,5,7,4,11,5,5};

        cs.sort(a);
}
    void sort(int arr[]){
        int [] count = new int[256];
        int [] output = new  int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            count[arr[i]]++;
        }
        int index = 0;
        for (int i = 0; i < 255 ; i++) {

            if(count[i]>0){
                for (int j = index; j < index+ count[i] ; j++) {
                output[j]= i;
                }
                index += count[i];
            }
        }

        System.out.print("Sorted character array is ");
        for (int i=0; i<output.length; ++i) System.out.print(output[i]);

    }
}

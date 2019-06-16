package programming2018.Arrays;

public class Segregate0sAnd1s {


	 /* Driver Program to test above functions */
    public static void main(String[] args) 
    {
    	Segregate0sAnd1s seg = new Segregate0sAnd1s();
        int arr[] = new int[]{0, 1, 0, 1, 1, 1};
        int i, arr_size = arr.length;
 
        seg.segregate0and1(arr, arr_size);
 
        System.out.print("Array after segregation is ");
        for (i = 0; i < 6; i++)
            System.out.print(arr[i] + " ");
    }

    
    
	private void segregate0and1(int[] arr, int arr_size) {

		int count = 0;
		
		for(int i = 0; i< arr_size; i++){		
			if(arr[i] == 0 ){
				if(count != i)
					swap(arr, i, count);			
				count++;
			}
			
		}
	}



	private void swap(int[] arr, int i, int count) {
		int temp = arr[i];
		arr[i] = arr[count];
		arr[count] = temp;
	}

}


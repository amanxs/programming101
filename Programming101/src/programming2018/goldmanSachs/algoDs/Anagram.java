package programming2018.goldmanSachs.algoDs;

public class Anagram {
    public static void main(String args[]){

    }

    static boolean areAnagram(String s1, String s2){
        int n1= s1.length();
        int n2= s2.length();

        if(n1!=n2)
            return false;

        //
        // programming2018.Arrays.sort(s1.toCharArray());
        quickSort(s1.toCharArray(),0, n1-1);
        quickSort(s2.toCharArray(), 0, n2-1);

        for(int i=0; i<n1; i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                return false;
            }
        }
        return true;

    }

    static void quickSort(char arr[], int l, int r){
        int pi;
        if(l<r){
            pi=partition(arr,l,r);
            quickSort(arr,l,pi-1);
            quickSort(arr,pi+1,r);

        }
    }

    static int partition(char arr[], int l, int r){
        int pivot = arr[r];
        int pivotIndex=l;
        for(int i = l; i<r; i++){
            if(less(arr[i],pivot)){
                swap(arr,pivotIndex,i);
                pivotIndex++;
            }
        }
        swap(arr,pivotIndex,r);
        return pivotIndex;

    }

    static void swap(char arr[], int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;

    }

    static void mergeSort(int arr[], int l,int r){

        if(l<r){
            int m = l+r-l/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);

            merge(arr,l,m,r);
        }

    }

    static void merge(int[] arr, int l, int m, int r){
        int nl = m-l;
        int nr = r-m;

        int L[] = new int[nl];
        int R[] = new int[nr];

        for(int i=0;i<nl;i++)
           L[i] =  arr[l+i];

        for(int j=0;j<nr;j++)
            R[j] = arr[m+j];

        //Merge the temp arrays

            int i= 0;
            int j= 0;
            int k = l;

        while(i<nl && j<nr){
            if(L[i]<R[j]){
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while(i<nl){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<nr){
            arr[k] = R[j];
            j++;
            k++;
        }




    }
}

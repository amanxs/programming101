package programming2018.jpMorgan;

public class InsertDashAndStars {
    /**
     * Insert dash between two odd numbers and star between two even numbers
     */

    public static void main(String[] args) {
        updateNumber(104875);
    }

    static void updateNumber(long num){
        String str = num+"";
        StringBuilder sb = new StringBuilder();
        char arr[] = str.toCharArray();

        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]%2==0 && arr[i+1]%2==0) {
                sb.append(arr[i]);
                sb.append('*');
            }

            else if(arr[i]%2==1 && arr[i+1]%2==1) {
                sb.append(arr[i]);
                sb.append('-');
            }
            else
                sb.append(arr[i]);
        }
        sb.append(arr[arr.length-1]);
        System.out.println(sb.toString());
    }
}

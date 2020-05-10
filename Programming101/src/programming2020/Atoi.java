package programming2020;

/**
 * The atoi() function in C takes a string (which represents an integer) as an argument and returns its value of type int.
 * So basically the function is used to convert a string argument to an integer.
 */
public class Atoi {
    public static void main(String args[]){

        int a = atoi("4231");
        System.out.print(a);

    }

    private static int atoi(String str) {
        char arr[] = str.toCharArray();
        int i =0;
        boolean isNegative = false;
        if(arr[0]=='-'){
            isNegative = true;
            i =1;
        }
        int number=0;
        for(; i< arr.length; i++){
            number = number*10 + arr[i]-'0';
        }

        return isNegative? -number : number;
    }
}

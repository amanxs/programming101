package programming2018.goldmanSachs.algoDs;

public class atoi {
    public static void main(String args[]){

        int a = atoi("-42");
        System.out.print(a);

    }

    private static int atoi(String s) {
        int result = 0;
        //boolean negative = false;
        int sign =1;
        int i = 0;
        if(s.charAt(0)=='-'){
            i++;
            //negative = true;
            sign =-1;
        }
        for (; i < s.length(); i++){

                result = result * 10 + s.charAt(i) - '0';

        }
        return sign*result;
    }

    private static boolean isNumeric(char x){
        return (x>='0' && x<='9');
    }

    static int implementAtoi(String s){
        char arr[] = s.toCharArray();

        int result = 0;
        int sign =1;
        int i =0;

        if(arr[i] == '-') {
            i++;
            sign = -1;
        }

        for(; i<s.length(); i++){

            if (isNumeric(arr[i]) == false)
                return 0; // You may add some lines to write error message
            // to error stream

            result = result*10 + arr[i]-'0';

        }
        return sign*result;
    }
}

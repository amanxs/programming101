package programming2018.Algorithms;

import java.util.HashMap;

public class NumberOfPossibleEmailAddresses {

    static HashMap<String, Boolean> map = new HashMap<>();

    public static void main(String args[]){
       int count =  possibleEmailAddresses("aman",4);
    }
    static int possibleEmailAddresses(String email, int n){
        if(n<1)
            return 0;

        if(!map.containsKey(email))
            System.out.println(email);

        map.put(email,true);

        return possibleEmailAddresses(decorateEmail(email,n-1), n-1) + possibleEmailAddresses(email,n-1);
    }

    static String decorateEmail(String email, int x){// x= 3
        char arr[] = email.toCharArray();
        char arrN[] = new char[arr.length+1];
        for(int i =0 ; i< x; i++)
            arrN[i] = arr[i];

        arrN[x] = '.';

        for(int j = x+1; j<= email.length() ;j++){
            arrN[j] = arr[j-1];
        }

        return String.valueOf(arrN);
    }
}

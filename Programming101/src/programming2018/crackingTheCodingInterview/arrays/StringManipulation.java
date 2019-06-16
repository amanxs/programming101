package programming2018.crackingTheCodingInterview.arrays;

import java.util.Arrays;

/**
 * Replace all spaces in a programming2018.String with %20
 */
public class StringManipulation {

    public static void main(String args[]){
        String s = "a bc d ef      ";
        System.out.println(s);

        char str[] = s.toCharArray();
        System.out.println(Arrays.toString(str));

        replace(str, 9);
    }

    //a bc d ef   ;

    static void replace(char str[], int length){

        int spaceCount = 0, newLength, i;

        for (i = 0; i < length; i++) {
            if(' ' == str[i])
                spaceCount++;
        }

        System.out.println(spaceCount);

        newLength = length + spaceCount*2;
        //str[newLength] = '\0';

        for( i=length-1; i>=0; i--){
            if(' ' == str[i]){
                str[newLength-1]='0';
                str[newLength-2]='2';
                str[newLength-3]='%';
                newLength -= 3;
            }
            else{
                str[newLength - 1] = str[i];
                newLength = newLength - 1;
            }
            System.out.println(Arrays.toString(str));

        }
        System.out.println(Arrays.toString(str));
    }

}

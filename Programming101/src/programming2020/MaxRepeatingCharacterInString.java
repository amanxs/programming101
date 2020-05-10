package programming2020;

/**
 * Given a string, the task is to find maximum consecutive repeating character in string.

 Note : We do not need to consider overall count, but the count of repeating that appear at one place.

 Input : str = "aaaabbcbbb"
 Output : a
 */
public class MaxRepeatingCharacterInString {

    public static void main(String[] args) {
        String s = "aaabbcbbb";
        char c = maxRepeatingChar(s);
        System.out.println(c);
    }

    //If 2 chars have the same count then it will print the one that comes later
    public static char maxRepeatingChar(String str){
        char arr[] = str.toCharArray();
        int currCount =0;
        int maxCount =0;
        char currChar = '0';
        char maxChar = '0';

        for(int i=1; i< arr.length; i++){
            if(currChar==arr[i]){
                currCount++;
            }
            else{
                currChar = arr[i];
                currCount=1;
            }
            if(currCount>maxCount){
                maxChar = currChar;
                maxCount = currCount;
            }
        }

        return maxChar;
    }
}

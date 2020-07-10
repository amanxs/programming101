import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

public class CustomSortString {
    int arr[] = new int[26];


        public String customSortString(String s, String t) {
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                arr[c-'a'] = i+1;
            }

            char arr2[] = t.toCharArray();


            int[][] intervals = new int[1][1];


            Character tempArray[] = new Character[2];

            Arrays.sort(tempArray, (a,b) -> compare(a,b));

            Arrays.sort(tempArray, new Comparator<Character>(){

                @Override
                public int compare(Character c1, Character c2)
                {
                    // ignoring case
                    return Character.compare(Character.toLowerCase(c1),
                            Character.toLowerCase(c2));
                }
            });
            return String.valueOf(arr2);

        }

        public int compare(char a, char b){
            return arr[a- 'a'] - arr[b -'a'];
        }

}

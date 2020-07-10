package programming2020;

import java.util.Arrays;

public class LongestSubWithoutRepeating {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s.length() == 1) return 1;
            //Set<Character> set = new HashSet<>();
            //Map<Character, Integer> map = new HashMap<>();
            int[] map = new int[26];
            Arrays.fill(map, -1);
            int start =0;
            int end =0;
            int max =0;
            for(;end<s.length();end++){
                char c = s.charAt(end);
                if(map[c-'a'] != -1){
                    int prevIndex = map[c-'a'];
                    if(prevIndex>=start){
                        start = prevIndex + 1;
                    }
                }

                max = Math.max(max, (end - start + 1));
                map[c - 'a'] = end;
            }

            return max;

        }
    }
}

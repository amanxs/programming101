package programming2020.leetcode.may_challenge;

public class EditDistance {



    public int minDistance(String word1, String word2, int m, int n){
        if(m==0) return n;// the only option is to insert all char from second to first
        if(n==0) return m; // the only option is to remove all char from first;

        if(word1.charAt(m) == word2.charAt(n)){
            return minDistance(word1, word2, m-1, n-1);
        }
        /**
         * Insert: Recur for m and n-1
         * Remove: Recur for m-1 and n
         * Replace: Recur for m-1 and n-1
         */
        return 1 + Math.min(minDistance(word1, word2, m-1, n-1),
                            Math.min(minDistance(word1, word2, m-1, n), minDistance(word1, word2, m, n-1)));
    }
}

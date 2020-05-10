package programming2020.leetcode.may_challenge;

public class JewelsAndStones {
    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
    }
    public int numJewelsInStones(String J, String S) {
        char jwels[] = J.toCharArray();
        char stones[] = S.toCharArray();
        //HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
        int arr[] = new int[256];
        //Arrays.fill
        for(int i=0; i< jwels.length; i++){
            //countMap.put(jwels[i], 1);
            arr[jwels[i]] = 1;
        }
        int count = 0;
        for(int i=0; i< stones.length; i++){
            // if(countMap.containsKey(stones[i])){
            //     count++;
            // }
            if(arr[stones[i]] ==1){
                count++;
            }
        }
        return count;

    }
}

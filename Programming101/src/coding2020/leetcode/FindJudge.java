package coding2020.leetcode;

import java.util.HashMap;

public class FindJudge {

    public int findJudgeOpt(int N, int[][] trust) {
        int arr[] = new int[N+1];

        for(int i=0; i< trust.length; i++){
            arr[trust[i][0]] -= 1;
            arr[trust[i][1]] += 1;
        }
        for(int i=1; i<N+1; i++){
            if(arr[i]==N-1){
                return i;
            }
        }

        return -1;
    }
     public int findJudge(int N, int[][] trust) {
            if(N==1 && trust.length==0){
                return 1;
            }
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();

            for(int i=0; i< trust.length; i++){
                int key = trust[i][0];
                int val = trust[i][1];
                map.put(key, val);
                if(countMap.containsKey(val)){
                    countMap.put(val, countMap.get(val) + 1);

                }
                else{
                    countMap.put(val, 1);
                }

            }
            int judge =-1;
            for(int val : countMap.keySet()){
                if(countMap.get(val) == N-1){
                    judge = val;
                    if(map.containsKey(judge)){
                        return -1;
                    }
                    else return judge;

                }
            }

            return judge;
        }

}

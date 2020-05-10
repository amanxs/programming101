package coding2020.leetcode;

import java.util.HashMap;

public class FindJudge {
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

package programming2020.leetcode.april_challenge;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

class FirstUnique {
    Queue<Integer> queue = new LinkedList<Integer>();
    LinkedHashMap<Integer, Integer> countMap = new LinkedHashMap<Integer, Integer>();

    public FirstUnique(int[] nums) {
        for(int i=0 ; i< nums.length ; i++){
            queue.add(nums[i]);
            if(countMap.containsKey(nums[i])){
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
            }
            else{
                countMap.put(nums[i], 1);
            }
        }
    }

    public int showFirstUnique() {
        for(int key : countMap.keySet()){
            if(countMap.containsKey(key)){
                if(countMap.get(key) == 1){
                    return key;
                }
            }
        }
        return -1;
    }

    public void add(int value) {
        queue.add(value);
        if(countMap.containsKey(value)){
            countMap.put(value, countMap.get(value) + 1);
        }
        else{
            countMap.put(value, 1);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
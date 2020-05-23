package programming2020.leetcode.may_challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class StockSpanner {

    Map<Integer, Integer> map = new HashMap<>();
    Stack<Integer> stack = new Stack<>();

    public StockSpanner() {

    }

    public int next(int price) {
        int count =1;
        while(!stack.isEmpty() && stack.peek()<= price){
            int e = stack.pop();
            if(map.containsKey(e)){
                count += map.get(e);
            }
        }
        stack.push(price);
        map.put(price,count);

        return count;
    }

}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
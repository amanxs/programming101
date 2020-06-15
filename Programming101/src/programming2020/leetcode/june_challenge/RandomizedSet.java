package programming2020.leetcode.june_challenge;

import java.util.*;

class RandomizedSet {

    Set<Integer> set;
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashSet<>();
        list = new ArrayList<Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(set.add(val)){
            list.add(val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(set.remove(val)){
            list.remove(new Integer(val));
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int n = set.size();
        int i = new Random().nextInt(n);
        return list.get(i);

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
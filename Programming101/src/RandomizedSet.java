import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class RandomizedSet {
    Set<Integer> index = new HashSet<>();
    List<Integer> list = new ArrayList<>();

    public RandomizedSet() { }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (index.contains(val)) return false;
        list.add(val);
        index.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!index.contains(val)) return false;
        index.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        while(!index.isEmpty()) {
            int randomIndex = (int) (Math.random() * list.size());
            int val = list.get(randomIndex);
            if (index.contains(val)) return val;
        }
        return 0;
    }
}
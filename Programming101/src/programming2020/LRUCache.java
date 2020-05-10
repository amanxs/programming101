package programming2020;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache {

    public static  Map<Integer, Integer> cache;
    public static  int size;
    public static Queue<Integer> queue;


    public LRUCache(int capacity) {
            cache = new HashMap<Integer, Integer>(capacity);
            queue = new LinkedList<Integer>();
            size =capacity;
        }

        public int get(int key) {
            if(cache.containsKey(key)){
                put(key, cache.get(key));
                return cache.get(key);
            }
            return -1;

        }

        public void put(int key, int value) {
            if(queue.size()== size){
                int e =queue.poll();
                cache.remove(e);
            }
            cache.put(key, value);
            queue.add(key);
        }


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}

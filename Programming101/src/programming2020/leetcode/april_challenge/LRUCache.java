package programming2020.leetcode.april_challenge;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 The cache is initialized with a positive capacity.

 Follow up:
 Could you do both operations in O(1) time complexity?

 Example:

 LRUCache cache = new LRUCache( 2 // capacity  );

 cache.put(1, 1);
 cache.put(2, 2);
 cache.get(1);       // returns 1
 cache.put(3, 3);    // evicts key 2
 cache.get(2);       // returns -1 (not found)
 cache.put(4, 4);    // evicts key 1
 cache.get(1);       // returns -1 (not found)
 cache.get(3);       // returns 3
 cache.get(4);       // returns 4

 */
public class LRUCache {
    private Map<Integer, Integer> map;

    private int CAPACITY;




    //This is the laziest implementation using Java's LinkedHashMap. In the real interview, however,
    // it is definitely not what interviewer expected.


    public LRUCache(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }

    public int getVal(int key) {
        return map.getOrDefault(key, -1);
    }

    public void set(int key, int value) {
        map.put(key, value);
    }


    /**
     * Several points to mention:
     * <p>
     * 1. In the constructor, the third boolean parameter specifies the ordering mode. If we set it to true, it will be in access order.
     * (https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html#LinkedHashMap-int-float-boolean-)
     * <p>
     * 2. By overriding removeEldestEntry in this way, we do not need to take care of it ourselves.
     * It will automatically remove the least recent one when the size of map exceeds the specified capacity.
     * (https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html#removeEldestEntry-java.util.Map.Entry-)
     */

    /*

    Great solution, but if constructor params is too confuse you then just straight forward implment the logic.

private LinkedHashMap<Integer, Integer> map;
private int SIZE;
public LRUCache(int capacity) {
    map = new LinkedHashMap<>();
    SIZE = capacity;
}

public int get(int key) {
    if(map.containsKey(key)) {
        int value = map.remove(key);
        map.put(key, value);
        return value;
    }
    return -1;
}

public void put(int key, int value) {
    if(map.containsKey(key)) {
        map.remove(key);
    }else if(map.size() + 1 > SIZE) {
        map.remove(map.keySet().iterator().next());
    }
    map.put(key, value);
}

     */


    //Below is a "normal" HashMap + doubly-linked list implementation:

                /*

    /**
     * When a page is referenced, the required page may be in the memory.
     * If it is in the memory, we need to detach the node of the list and bring it to the front of the queue.
     If the required page is not in the memory, we bring that in memory.
     In simple words, we add a new node to the front of the queue and update the corresponding node address in the hash.
     If the queue is full, i.e. all the frames are full, we remove a node from the rear of queue, and add the new node to the front of queue.

     */


    //Analysis : The key to solve this problem is using a double linked list which enables us to quickly move nodes.

    private Map<Integer, Node> cache;
    private Node head, tail;
    private int count;

    public LRUCache(int cap, int version) {
        cache = new HashMap<>();
        CAPACITY = cap;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;

    }

    private class Node{
        int key, value;
        Node next, prev;
        Node(int k, int v){
            key =k;
            value = v;

        }
        Node(){
            this(0, 0);
        }
    }

    public int get(int key){
        if(cache.containsKey(key)){
            Node node= cache.get(key);
            int val = node.value;
            update(node);
            return val;
        }
        return -1;
    }

    public void put(int key, int val){
        if(map.containsKey(key)){
            Node node= cache.get(key);
            node.value = val;
            //cache.put(key, node);
            update(node);        }
        else{
            Node node = new Node(key, val);
            cache.put(key, node);
            add(node);
            if(count>=CAPACITY){
                remove(tail.prev);
                map.remove(tail.prev.key);
            }
            else{
               count++;
            }
        }

    }
    private void update(Node node){
        remove(node);
        add(node);
    }

    private void add(Node node){
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;

    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}
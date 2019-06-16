package programming2018.morganStanley;


import java.util.HashMap;

/**
 * The LRU caching scheme is to remove the least recently used frame when the cache is full
 * and a new page is referenced which is not there in cache.
 */
public class LRUCache {

/*
We use two data structures to implement an LRU Cache.

Queue which is implemented using a doubly linked list. The maximum size of the queue will be equal to the total number of frames
available (cache size).The most recently used pages will be near front end and least recently pages will be near rear end.
A Hash with page number as key and address of the corresponding queue node as value.

 */

// This is the node of the doubly linkedList
class Node{
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }

    /**
     * When a page is referenced, the required page may be in the memory.
     * If it is in the memory, we need to detach the node of the list and bring it to the front of the queue.
     If the required page is not in the memory, we bring that in memory.
     In simple words, we add a new node to the front of the queue and update the corresponding node address in the hash.
     If the queue is full, i.e. all the frames are full, we remove a node from the rear of queue, and add the new node to the front of queue.

     */


    //Analysis : The key to solve this problem is using a double linked list which enables us to quickly move nodes.

    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node end = null;

    public int get(int key){
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }

        return -1;

    }

    public void set(int key, int value){
        if(map.containsKey(key)){
            Node present = map.get(key);
            present.value = value;
            remove(present);
            setHead(present);
        }
        else {
            Node node = new Node(key, value);
            if(map.size()>=capacity){
                map.remove(end.key);
                remove(end);
                setHead(node);
            }
            else
                setHead(node);

            map.put(key,node);
        }

    }

    private void remove(Node n){

        if(n.next!=null)
            n.prev.next = n.next;
        else
            end=n.prev;

        if(n.prev!=null)
            n.next.prev = n.prev;
        else
           head =  n.next;
    }

    private void setHead(Node n){
        n.next = head;
        n.prev = null;

        if(null!=head)
            head.prev = n;

        head = n;

        if(null==end)
            end=head;
    }
}
}


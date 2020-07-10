import java.lang.reflect.Array;

public class LinkedHashMap<K, V> {

    int size;
    static int CAPACITY= 16;
    static int LOAD_FACTOR;

    Node[] table ;
    Node curr;
    Node head;

    public LinkedHashMap(Class<Node> c) {
        table= (Node[])Array.newInstance(c);

    }


    class Node{
        K key;
        V val;
        Node next;
        Node prev;
        Node after;
        int hash;
    }

    public void put(K key, V value){
        int h = hash(key);
        int index = h%CAPACITY;
        for(Node n = table[index]; n!= null ;n = n.next){

            if(n.key == key){
                n.val = value;
            }

        }

        add(h, key, value, index);

    }

    private void add(int h, K key, V value, int index) {
        Node node = new Node();
        node.key = key;
        node.val = value;
        node.hash = h;
        node.next = null;
        node.after = null;
        if(null!= curr){
        node.prev = curr;
        curr.after = node;
        }
        else{
            node.prev = null;
            head = node;
        }
        curr = node;

        table[index] = node;

    }

    public V get(K key){
        int h = hash(key);
        int index = h%CAPACITY;

        for(Node n = table[index]; n!= null ;n = n.next){
            if(n.key == key){
                return n.val;
            }
        }
        return null;
    }

    private void printNodes(){
        Node node = head;

        while(node.after != null){
            System.out.println(node.val);
            node = node.after;
        }


    }

    public static void main(String[] args) {
        LinkedHashMap map = new LinkedHashMap(String[].class);
        map.put(1, "first");
        map.put(2, "second");
        map.printNodes();
    }

    public int hash(K key){
        return key.hashCode();
    }
}

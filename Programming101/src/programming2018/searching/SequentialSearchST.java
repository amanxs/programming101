package programming2018.searching;

/**
 * This ST implementation uses a private Node inner class to keep the keys and values in an unordered linked list.
 * The get() implementation searches the list sequentially to find whether the key is in the table (and returns the associated value if so).
 * The put() implementation also searches the list sequen- tially to check whether the key is in the table.
 * If so, it updates the associated value; if not, it creates a new node with the given key and value and inserts it at the beginning of the list.
 * @param <Key>
 * @param <Value>
 */
public class SequentialSearchST<Key, Value> {
    private Node first;
    private class Node
    {  // linked-list node
        // first node in the linked list
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next)
        {
            this.key  = key;
            this.val  = val;
            this.next = next;
        } }
    public Value get(Key key)
    {  // Search for key, return associated value.
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return x.val;    // search hit
        return null;           // search miss
    }
    public void put(Key key, Value val)
    {  // Search for key. Update value if found; grow table if new.
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
            {  x.val = val; return;  }      // Search hit: update val.
        first = new Node(key, val, first); // Search miss: add new node.
    }
}
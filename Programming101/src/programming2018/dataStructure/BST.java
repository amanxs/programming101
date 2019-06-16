package programming2018.dataStructure;

/*	We define a private nested class to define nodes in BSTs, just as we did for linked lists.
 *  Each node contains a key, a value, a left link, a right link, and a node count
 *  (when relevant, we include node counts in red above the node in our drawings).
 *   The left link points to a BST for items with smaller keys, and the right link points to a BST 
 *   for items with larger keys.
 *   The instance variable N gives the node count in the subtree rooted at the node
 */
public class BST<Key extends Comparable<Key>, Value> {
    /*
     * A BST represents a set of keys (and associated values), and there are
     * many different BSTs that represent the same set. If we project the keys
     * in a BST such that all keys in each node’s left subtree appear to the
     * left of the key in the node and all keys in each node’s right subtree
     * appear to the right of the key in the node, then we always get the keys
     * in sorted order. We take advantage of the flexibility inherent in having
     * many BSTs represent this sorted order to develop efficient algorithms for
     * building and using BSTs.
     */
    private Node root; // root of BST

    private class Node {
        private Key key; // key
        private Value val; // associated value
        private Node left, right; // links to subtrees
        private int N; // # nodes in subtree rooted here

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null)
            return 0;
        else
            return x.N;
    }

    public Value get(Key key) {
        return get(key, root);
    }

    private Value get(Key key, Node node) {

        if (node == null)
            return null;

        if (key.compareTo(node.key) < 0)
            return get(key, node.left);
        else if (key.compareTo(node.key) > 0)
            return get(key, node.right);
        else
            return node.val;
    }

    public void put(Key key, Value value) { // Search for key. Update value if
        // found; grow table if new.
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value val) {
        // Change key’s value to val if key in subtree rooted at x.
        // Otherwise, add new node to subtree associating key with val.
        if (x == null)
            return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        else
            x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null)
            return x;
        return min(x.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null)
            return x;
        return max(x.right);
    }

    //largest key smaller or equal to x
    public Key floor(Key key) {
        Node node = floor(key, root);
        if (node == null) return null;
        return node.key;
    }

    private Node floor(Key key, Node node) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        if (cmp < 0) return floor(key, node.left);
        Node t = floor(key, node.right);
        if (t != null) return t;
        else return node;
    }

    // smallest key larger or equal to x
    public Key ceiling(Key key) {
        Node node = ceiling(key, root);
        if (node == null) return null;
        return node.key;
    }

    private Node ceiling(Key key, Node root) {
        int cmp = key.compareTo(root.key);
        if (cmp > 0) return ceiling(key, root.right);
        Node t = ceiling(key, root.left);
        return null;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    // Return number of keys less than x.key in the subtree rooted at x.
    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 1) return rank(key, x.left);
        else if (cmp > 1) return 1 + size(x.left) + rank(key, x.right);
        return size(x.left);
    }

    // We seek the key of rank k (the key such that precisely k other keys in the BST are smaller)
    public Node select(int k) {
        return select(k, root);
    }

    private Node select(int k, Node x) {
        if (x == null) return null;
        int t = size(x.left);
        if      (t > k) return select(k, x.left);
        else if (t < k) return select(k - t - 1, x.right);
        else            return x;
    }

    public void delete(Key key){
        delete(key,root);
    }

    private Node delete(Key key, Node x) {
        if (x==null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp<0) x.left = delete(key, x.left);
        else if (cmp>0) x.right = delete(key, x.right);
        else{
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x= min(t.right);
            x.right = t.right;
            x.left=t.left;


        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    //In order Traversal

    public Iterable<Key> keys(){
        return keys(min(), max());
    }

    private Iterable<Key> keys(Key lo, Key hi) {

        Queue<Key> queue = new Queue<Key>();
        keys(root,queue,lo,hi);
        return queue;
    }

/*
    To enqueue all the keys from the tree rooted at a given node that fall in a given range onto a queue,
    we (recursively) enqueue all the keys from the left subtree (if any of them could fall in the range),
    then enqueue the node at the root (if it falls in the range),
    then (recursively) enqueue all the keys from the right subtree (if any of them could fall in the range).
*/
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if(x==null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if(cmplo<0) keys(x.left,queue,lo,hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enque(x.key);
        if(cmphi>0) keys(x.right,queue,lo,hi);
    }
}

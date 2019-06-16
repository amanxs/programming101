package programming2019.dataStructures;

/**
 * This implementation of the ordered symbol-table API uses a binary search tree built from Node objects that each contain a key,
 * associated value, two links, and a node count N. Each Node is the root of a subtree containing N nodes,
 * with its left link pointing to a Node that is the root of a subtree with smaller keys and its right link pointing to a Node
 * that is the root of a subtree with larger keys. The instance variable root points to the Node at the root of the
 * BST (which has all the keys and associ- ated values in the symbol table).
 *
 * @param <Key>
 * @param <Value>
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {

        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        Node(Key key, Value val, int N) {
            this.key = key;
            this.value = val;
            this.N = N;
            left = null;
            right = null;
        }

    }


    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    public Value get(Key key) {
        return get(key, root);
    }

    private Value get(Key key, Node node) {
        if (null == node) return null;
        int cmp = node.key.compareTo(key);
        if (cmp > 0) return get(key, node.left);
        else if (cmp < 0) return get(key, node.right);
        else return node.value;
    }

    public void put(Key key, Value value) {
        put(key, value, root);
    }

    private Node put(Key key, Value value, Node x) {
        if (null == x) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp > 0) put(key, value, x.right);
        else if (cmp < 0) put(key, value, x.left);
        else x.value = value;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        return (x == null) ? null : x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        // Return Node containing key of rank k.
        if (null == x) return null;
        int t = size(x.left);
        if (k < t) return select(x.left, k);
        else if (k > t) return select(x.right, k - t - 1);
        else return x;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        // Return number of keys less than x.key in the subtree rooted at x.
        if(x==null) return 0;
        int cmp = key.compareTo(x.key);
        if(cmp<0) return rank(key, x.left);
        else if(cmp>0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }


    /**
     * For deleteMin() we go left until finding a Node that has a null left link and then replace the link to that node by its right link
     * (simply by returning the right link in the recursive method). The deleted node, with no link now pointing to it,
     * is available for garbage collection.
     */
    public void deleteMin(){
        deleteMin(root);
    }

    private Node deleteMin(Node x) {
       if (x.left==null) return x.right;
       x.left = deleteMin(x.left);
       x.N = size(x.left) + size(x.right) + 1;
       return x;
    }

    public void delete(Key key){
        delete(root, key);
    }

    private Node delete(Node x, Key key) {

        int cmp = key.compareTo(x.key);
        if(cmp<0) x.left = delete(x.left, key);
        if(cmp>0) x.right = delete(x.right, key);

        Node successor = successor(x);
        successor.left = x.left;
        successor.right = x.right;

        return null;
    }

    private Node successor(Node x) {
        return null;
    }
}

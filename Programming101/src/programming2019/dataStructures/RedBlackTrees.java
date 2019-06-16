package programming2019.dataStructures;

public class RedBlackTrees<Key, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        Key key;            //key
        Value value;        //Associated Value
        Node left, right;   //Subtrees
        int N;              //# nodes in this tree
        boolean color;      //color of link from parent to this node

        Node(Key key, Value val, int N, boolean color) {

        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    /**
     * First, suppose that we have a right-leaning red link that needs to be rotated to lean to the left (see the diagram at left).
     * This operation is called a left rotation.
     * We organize the computation as a method that takes a link to a red-black BST as argument and, assuming that link to be to a Node h
     * whose right link is red, makes the necessary adjustments and returns a link to a node that is the root of a red-black BST
     * for the same set of keys whose left link is red.
     *
     * @param h
     * @return
     */
    Node rotateLeft(Node h) {

        Node x = h.left;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left)
                + size(h.right);
        return x;
    }

    void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private int size(Node n) {
        return size(n.left) + size(n.right) + 1;
    }
}

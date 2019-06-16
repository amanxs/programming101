package programming2018.dataStructure;

public class RedBlackTrees<Key extends Comparable<Key>, Value> {

    private Node root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{

        private Key key; // key
        private Value val; // associated data
        Node left,right;  // subtrees
        int N; // # of nodes in this subtrees
        boolean color; // color of link from parent to this node.

        public Node(Key key, Value val, int N, boolean color){
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
        private boolean isRed(Node x)
        {
            if (x == null) return false;
            return x.color == RED;
        }

    }
}

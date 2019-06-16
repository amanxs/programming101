package programming2018.hackerRank.trees;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTrees {

    // Root of Binary Tree
    Node root;

    // Constructors
    BinaryTrees(int key)
    {
        root = new Node(key);
    }

    BinaryTrees()
    {
        root = null;
    }

    public static void main(String[] args)
    {
        BinaryTrees tree = new BinaryTrees();

        /*create root*/
        tree.root = new Node(1);

        /* following is the tree after above statement

              1
            /   \
          null  null     */

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        /* 2 and 3 become left and right children of 1
               1
             /   \
            2      3
          /    \    /  \
        null null null null  */


        tree.root.left.left = new Node(4);
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
         */
    }

    static class Node<T>{
        int data;
        Node left, right;

        Node(int data){
            data = data;
            left = right = null;
        }
    }


        void preOrder(Node root) {

            if (root != null) {
                System.out.print(root.data + " ");
                preOrder(root.left);
                preOrder(root.right);
            }
        }

    void postOrder(Node root) {

        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }

    void inOrder(Node root) {

        if(root!=null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

    }

    void levelOrderUsingQueue(Node root){
        /**
         * ArrayDeque is likely to be faster than
         * {@link Stack} when used as a stack, and faster than {@link LinkedList}
         * when used as a queue.
         */

        ArrayDeque<Node> queue = new ArrayDeque<Node>();

        if(root!=null)
            queue.add(root);

        while(!queue.isEmpty()){
            Node n = queue.poll();

            System.out.print(n.data+" ");

            if(null!=n.left)
                queue.add(n.left);

            if(null!=n.right)
                queue.add(n.right);

        }
        //backock
    }

    void levelOrder(Node root) {
        int h = height(root);
        for (int i = 1; i <h ; i++) {
            printGivenLevel(root, i);
        }

    }

    private void printGivenLevel(Node root, int level) {

        if (root == null)
            return;

        if(level==1)
            System.out.print(root.data + " ");
        if(level>1){
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

    void topView(Node root) {

        if (root != null) {
            printLeft(root.left);
            System.out.print(root.data + " ");
            printRight(root.right);
        }

    }

    private void printLeft(Node node) {
        if(node!=null){
            printLeft(node.left);
            System.out.print(node.data+ "");
        }
    }

    private void printRight(Node node) {
        if(node!=null){
            System.out.print(node.data+ " ");
            printRight(node.right);
        }

    }

     int height(Node root) {
        // Write your code here.
        if(root == null)
            return 0;
        else
            return Math.max(height(root.left), height(root.right)) +1;

    }

    int diameter(Node root){

        if(root==null)
            return 0;

        //get the diameter of the left and rigth subtrees
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        //get the height of the left and rigt subtrees
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        /* Return max of following three
        1) Diameter of left subtree
        2) Diameter of right subtree
        3) Height of left subtree + height of right subtree + 1 */

        int diameter = lHeight + rHeight +1;
        return Math.max(diameter, Math.max(ldiameter,rdiameter));
    }

    /**
     *
     * @param node
     * @param a
     * @param b
     * @return
     */
    Node lca(Node node, int a, int b){
        /*
        The idea is to traverse the tree starting from root.
        If any of the given keys (n1 and n2) matches with root, then root is LCA (assuming that both keys are present).
        If root doesn’t match with any of the keys, we recur for left and right subtree.
        The node which has one key present in its left subtree and the other key present in right subtree is the LCA.
        If both keys lie in left subtree, then left subtree has LCA also, otherwise LCA lies in right subtree.
         */
        if(node == null)
            return null;

        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if(node.data == a || node.data == b)
            return root;

        // Look for keys in left and right subtrees
        Node left = lca(node.left, a, b);
        Node right = lca(node.right, a , b);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if(null!= left && null != right)
            return node;


        return left!=null ? left : right;
    }

    // Time Complexity: Time complexity of the above solution is O(n)
    // as the method does a simple tree traversal in bottom up fashion.

    /**
     * Note that the above method assumes that keys are present in Binary Tree.
     * If one key is present and other is absent, then it returns the present key as LCA (Ideally should have returned NULL).
     * We can extend this method to handle all cases by passing two boolean variables v1 and v2.
     * v1 is set as true when n1 is present in tree and v2 is set as true if n2 is present in tree.
     */

    static boolean v1 =false;
    static boolean v2 = false;

    Node lcaOptimized(Node node, int a, int b){

        if (node.data == a)
        {
            v1 = true;
            return node;
        }

        if (node.data == b)
        {
            v2 = true;
            return node;
        }

        // Look for keys in left and right subtrees
        Node left_lca = lcaOptimized(node.left, a, b);
        Node right_lca = lcaOptimized(node.right, a, b);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null)
            return node;

        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }
}


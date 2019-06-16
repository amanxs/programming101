package programming2018.goldmanSachs.algoDs;

import java.util.ArrayList;

public class CheckIfGivenTreeIsBinaryTree {

    public static void main(String args[]){
        CheckIfGivenTreeIsBinaryTree tree = new CheckIfGivenTreeIsBinaryTree();
        tree.root = new Node(3);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(4);

        if (tree.checkIfBst())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }

    static Node root;
    static Node prev; // For solution with inorder traversal with space optimization
    static ArrayList<Integer> list = new ArrayList<Integer>(); // For solution with inorder traversal


    static class Node{
        int data;
        Node left;
        Node right;

        Node(int d){
            data = d;
            left=right=null;
        }
    }

    static boolean checkIfBst(){
        //return checkBst(root,Integer.MAX_VALUE, Integer.MIN_VALUE);
        return checkBSTUsingInOrderTraversalWithSpaceOptimization(root);
        //return checkBSTUsingInorderTraversal(root);

    }

    static boolean checkBst(Node node, int max, int min){

        if(node==null)
            return true;

        if(node.data>max || node.data < min)
            return false;

        return checkBst(node.left,node.data,min) && checkBst(node.right, max, node.data);
    }


/**
 * METHOD 2(Using In-Order Traversal)
 Thanks to LJW489 for suggesting this method.
 1) Do In-Order Traversal of the given tree and store the result in a temp array.
 3) Check if the temp array is sorted in ascending order, if it is, then the tree is BST.

 Time Complexity: O(n)
 */

    static boolean checkBSTUsingInorderTraversal(Node node){
        if(node!=null){
            checkBSTUsingInorderTraversal(node.left);
            list.add(node.data);
            checkBSTUsingInorderTraversal(node.right);
        }

        for (int i = 0 ; i<list.size()-1; i++) {
            if ((list.get(i) > list.get(i + 1)))
                return false;
        }
        return true;
    }

    /**
     * We can avoid the use of Auxiliary Array. While doing In-Order traversal, we can keep track of previously visited node.
     * If the value of the currently visited node is less than the previous value, then tree is not BST.
     */
    static boolean checkBSTUsingInOrderTraversalWithSpaceOptimization(Node node){

        if(null!=node) {

            checkBSTUsingInOrderTraversalWithSpaceOptimization(node.left);

           if(prev != null && prev.data >node.data)
                return false ;
            prev = node;

            checkBSTUsingInOrderTraversalWithSpaceOptimization(node.right);

        }
        return true;
    }
}
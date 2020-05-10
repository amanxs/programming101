package programming2020.leetcode.april_challenge;

public class BinaryTreeDiameter {

    static Node root;


    static class Node{
        Node left;
        Node right;
        int data;

         Node(int d){
            data = d;
            left = right = null;
        }

    }

    public static int height(Node node){
        if(node == null){
            return 0;
        }

        return 1+ Math.max(height(node.left), height(node.right));
    }

    public static int diameter(Node node){
        if(node == null){
            return 0;
        }

        int lheight = height(node.left);
        int rHeight = height(node.right);

        int lDiamater = diameter(node.left);
        int rDiameter = diameter(node.right);

        return Math.max(1+ lheight + rHeight ,Math.max(lDiamater, rDiameter));
    }

    public static int diameter(){
    return diameterOfBinaryTreeOptimized(root);
    }

    /**
     * And O(n) approach to calculate the diameter of a Binary Tree
     */

    static int ans;

    public static int diameterOfBinaryTreeOptimized(Node root) {
        ans =1;
        depthAndWidth(root);
        return ans-1;

    }

    //This method computes the width in the ans variable at the same time as the depth
    public static int depthAndWidth(Node node){
        if(null == node){
            return 0;
        }
        int lHeight = depthAndWidth(node.left);
        int rHeight = depthAndWidth(node.right);
        ans = Math.max(ans, lHeight + rHeight +1);
        return 1 + Math.max(lHeight, rHeight);

    }

    public static void main(String args[]){
        BinaryTreeDiameter tree = new BinaryTreeDiameter();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("The diameter of given binary tree is : "
                + tree.diameter());
    }




}

package programming2020;

import java.util.Stack;

public class SpiralOrderTraversalTree {

    static Node root;

    static class Node{
        Node left;
        Node right;
        int data;
        Node(int d){
            data =d;
            left = right = null;
        }
    }

    public static void printSpiral(Node node){
        Stack<Node> stackLeft = new Stack<Node>();
        Stack<Node> stackRight = new Stack<Node>();

        stackLeft.push(node);

        while(!stackLeft.isEmpty() || !stackRight.isEmpty()) {
            while (!stackLeft.isEmpty()) {
                Node temp = stackLeft.pop();
                System.out.println(temp.data);
                if (temp.right != null) {
                    stackRight.push(temp.right);
                }

                if (temp.left != null) {
                    stackRight.push(temp.left);
                }
            }

            while (!stackRight.isEmpty()) {
                Node temp = stackRight.pop();
                System.out.println(temp.data);

                if (temp.left != null) {
                    stackLeft.push(temp.left);
                }

                if (temp.right != null) {
                    stackLeft.push(temp.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        SpiralOrderTraversalTree tree = new SpiralOrderTraversalTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);
        System.out.println("Spiral Order traversal of Binary Tree is ");
        tree.printSpiral(root);
    }
}

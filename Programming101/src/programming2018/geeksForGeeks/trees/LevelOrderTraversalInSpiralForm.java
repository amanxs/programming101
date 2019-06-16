package programming2018.geeksForGeeks.trees;

import java.util.Stack;

public class LevelOrderTraversalInSpiralForm {

    Node root;

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }



    /**
     * Time Complexity: Worst case time complexity of the above method is O(n^2). Worst case occurs in case of skewed programming2018.trees.
      * @param head
     */
        static void printSpiralOrderTraversalRecursive(Node head){
            int h = height(head);
            boolean spiral = true;
            for(int i=0; i<h; i++){
                printGivenLevel(head,i, spiral);
                spiral=!spiral;
            }
        }

        static void printGivenLevel(Node node, int level, boolean spiral){

            if(node==null)
                return;

            if(level==0)
                System.out.print(node.data + " ");

            else if(spiral){
                printGivenLevel(node.right, level - 1, spiral);
                printGivenLevel(node.left, level - 1, spiral);

            }
            else {
                printGivenLevel(node.left, level - 1, spiral);
                printGivenLevel(node.right, level - 1, spiral);
            }
        }

        static int height(Node node){
            if(node==null)
                return 0;
            return 1 +Math.max(height(node.left), height(node.right));
        }


    /**
     * Method 2 (Iterative)
     We can print spiral order traversal in O(n) time and O(n) extra space.
     The idea is to use two stacks. We can use one stack for printing from left to right and other stack for printing from right to left.
     In every iteration, we have nodes of one level in one of the stacks.
     We print the nodes, and push nodes of next level in other stack.
     */

    static void printSpiralOrderTraversalIterative(Node node){
        Stack<Node> stackLeft = new Stack<Node>();
        Stack<Node> stackRight = new Stack<Node>();

        stackLeft.push(node);


        while(!stackLeft.isEmpty()){
            Node popped = stackLeft.pop();
            System.out.println(popped.data);
            if(popped.left!=null)
                stackRight.push(popped.left);
            if(popped.right!=null)
                stackRight.push(popped.right);
        }

        while(!stackRight.isEmpty()){

            Node popped = stackRight.pop();
            System.out.println(popped.data);

            if(popped.left!=null)
                stackLeft.push(popped.left);
            if(popped.right!=null)
                stackLeft.push(popped.right);

        }

    }

    public static void main(String[] args) {
            LevelOrderTraversalInSpiralForm tree = new LevelOrderTraversalInSpiralForm();
            tree.root = new Node(1);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left = new Node(7);
            tree.root.left.right = new Node(6);
            tree.root.right.left = new Node(5);
            tree.root.right.right = new Node(4);
            System.out.println("Spiral order traversal of Binary Tree is ");
            tree.printSpiralOrderTraversalRecursive(tree.root);
        }
    }



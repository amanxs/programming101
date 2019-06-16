package programming2019.geeksForGeeks.mustDoCodingQuestions.trees;


import java.util.LinkedList;
import java.util.Queue;

public class PrintLeftViewOfBinaryTree {
    /* testing for example nodes */
    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        PrintLeftViewOfBinaryTree tree = new PrintLeftViewOfBinaryTree();
        tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);

        tree.leftViewUtil(root,1);
    }

    static class Node{
        Node right;
        Node left;
        int data;
        Node(int d ){
            data = d;
            left=right = null;
        }
    }

    static Node root;

    //This is incomplete
    private static void leftView(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Queue<Node> result = new LinkedList<>();
        result.add(root);
        while (!queue.isEmpty()){
            Node node =  queue.poll();
            if (node.left!=null){
                queue.add(node.left);
                result.add(node.left);
            }
            else if (node.left==null && node.right!=null){
                queue.add(node.right);
                result.add(node.right);
            }
        }
    }

    static int count=0;
    private static void leftViewUtil(Node node, int level){
        if(node==null)
            return;

        if(isTheLeftMostNodeOnThisLevel(level)){
            System.out.println(node.data);
            count++;
        }
        leftViewUtil(node.left, level +1);
        leftViewUtil(node.right, level+1);
    }

    private static boolean isTheLeftMostNodeOnThisLevel(int level) {
        return (level>count);
    }
}

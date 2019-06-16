package programming2019.geeksForGeeks.mustDoCodingQuestions.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    static class Node{
        Node left;
        Node right;
        int data;
        Node(int d){
            data = d;
            left=right = null;
        }
    }

    static Node root;

    public void levelOrderTraversal(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);

            System.out.println(node.data);
        }
    }

    public static void main(String args[])
    {
        /* creating a binary tree and entering
         the nodes */
        LevelOrderTraversal tree_level = new LevelOrderTraversal();
        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
        tree_level.root.left.left = new Node(4);
        tree_level.root.left.right = new Node(5);

        System.out.println("Level order traversal of binary tree is - ");
        tree_level.levelOrderTraversal(root);
    }
}

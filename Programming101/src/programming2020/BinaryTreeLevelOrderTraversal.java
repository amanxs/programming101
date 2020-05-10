package programming2020;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    Node root;

    static class Node{
        Node left;
        Node right;
        int data;
        Node(int d){
            data = d;
            left = right = null;
        }
    }

    public void levelOrderTraversal(Node root){
        Queue<Node> queue = new LinkedList();
        queue.add(root);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println(node.data);
            if(null!= node.left)
                queue.add(node.left);
            if(null!= node.right)
                queue.add(node.right);
        }
    }

    public void printLevelOrder(){
        levelOrderTraversal(root);
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal tree_level = new BinaryTreeLevelOrderTraversal();
        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
        tree_level.root.left.left = new Node(4);
        tree_level.root.left.right = new Node(5);

        System.out.println("Level order traversal of binary tree is - ");
        tree_level.printLevelOrder();
    }
}

package programming2018.hackerRank.trees;

import java.util.Scanner;

public class SwapNodes {

    static class Node{
        int data;
        Node left, right;

        Node(int data){
            data = data;
            left = right = null;
        }
        Node(){
            left = right = null;
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfNodes = in.nextInt();
        int depthOfTree = 1;
        Node root = new Node(1);
        Node node = new Node();
        node= root;
        for (int i = 0; i < numberOfNodes; i++) {
            int leftChildIndex = in.nextInt();
            int rightChildIndex = in.nextInt();
            Node left = new Node(leftChildIndex);
            Node right = new Node(rightChildIndex);
            node.left =left;
            node.right = right;
            node = node.left;
        }

        int T = in.nextInt();
        for (int i = 0; i < T ; i++) {
            int K = in.nextInt();
            for (int h = K; h < numberOfNodes; h=2*h) {

            }
            //swap(K);
        }

    }

    private void inOrderTraversal(Node root){
        Node n = root;
        while(n!=null){
            inOrderTraversal(n.left);
            System.out.print(n.data + "");
            inOrderTraversal(n.right);
        }
    }
}

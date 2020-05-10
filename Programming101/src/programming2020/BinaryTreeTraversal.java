package programming2020;

public class BinaryTreeTraversal {
     Node root;

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            data=d;
        }
    }

    public void printInorder(Node node){
        if(null == node){
            return;
        }
        printInorder(node.left);
        System.out.println(node.data);
        printInorder(node.right);
    }

    public void printPreorder(Node node){
        if(null == node){
            return;
        }
        System.out.println(node.data);
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public void printPostorder(Node node){
        if(null == node){
            return;
        }
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.println(node.data);

    }

    public void printInorder(){
        printInorder(root);
    }
    public void printPreorder(){
        printPreorder(root);
    }
    public void printPostorder(){
        printPostorder(root);
    }

    public static void main(String[] args) {
        BinaryTreeTraversal tree = new BinaryTreeTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder();

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder();
    }
}

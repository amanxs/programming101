package programming2020;

public class CheckForBST {

    Node root;
    static Node prev;

    static class Node{
        Node left;
        Node right;
        int data;
        Node(int d){
            data = d;
            left = right = null;
        }
    }

    public static boolean isBST(Node node, int max, int min){

        if(null == node){
            return true;
        }

        int data = node.data;

        if(data > max || data < min){
            return false;
        }

        return isBST(node.left , node.data, min) && isBST(node.right, max, node.data);

    }

    public static boolean checkBSTUsingInorder(Node node){
        if(null == node){
            return true;
        }

         boolean isBST = checkBSTUsingInorder(node.left);
        System.out.println("Curr : " + node.data + " Prev : " + prev);

        if(!isBST || prev != null && node.data < prev.data){
            return false;
        }
        prev = node;

        return checkBSTUsingInorder(node.right);
    }

    public static boolean isBST(Node root){
        return checkBSTUsingInorder(root);
        //return isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static void main(String args[]){
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(4);

        if (isBST(root))
            System.out.print("Is BST");
        else
            System.out.print("Not a BST");
    }
}


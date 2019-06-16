package programming2019.geeksForGeeks.mustDoCodingQuestions.trees;

public class CheckForBst {
    static class Node{
        Node left;
        Node right;
        int data;
        Node(int d){
            data =d;
            left = right = null;
        }

    }


    static Node root;

    public static boolean isBst(Node node){
        return  isBstUsingInorderTraversal(node);
    }

    private static boolean isBst(Node node, int maxValue, int minValue) {
        if(node==null)
            return true;
        if(maxValue>node.data && node.data > minValue )
            return isBst(node.left, node.data, minValue) && isBst(node.right, maxValue, node.right.data);
        return false;
    }
    static Node prev=null;
    static Node curr = null;
    private static boolean isBstUsingInorderTraversal(Node node){
        if(null!=node) {

            isBstUsingInorderTraversal(node.left);
            if (!areNodesInSortedOrder(node)) return false;

            isBstUsingInorderTraversal(node.right);
        }
        return true;
    }

    private static boolean areNodesInSortedOrder(Node node) {
        curr = node;
        if (null != prev && curr.data < prev.data) {
            return false;
        }
        prev = node;
        return true;
    }

    public static void main(String args[])
    {
        CheckForBst tree = new CheckForBst();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(6);

        if (tree.isBst(root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}

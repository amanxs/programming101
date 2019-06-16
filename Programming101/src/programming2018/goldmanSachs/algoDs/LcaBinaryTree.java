package programming2018.goldmanSachs.algoDs;

public class LcaBinaryTree {
    static class Node{
        Node left, right;
        int data;

        Node(int item){
            data = item;
            left = right = null;
        }
    }

        static Node root;

        static Node findLCA(int n1, int n2){

            findLca(root, n1,n2);
            return null;
        }

        static Node findLca(Node root, int n1, int n2){

            if(root==null)
                return null;

            if(root.data == n1 || root.data==n2)
                return root;

            Node Node_left = findLca(root.left, n1, n2);
            Node Node_right = findLca(root.right, n1, n2);

            if(Node_left!=null && Node_right != null)
                return root;

            else if(Node_left!= null)
                return findLca(root.left, n1, n2);
            else
                return findLca(root.right, n1, n2);

        }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        LcaBinaryTree tree = new LcaBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("LCA(4, 5) = " +
                tree.findLCA(4, 5).data);
        System.out.println("LCA(4, 6) = " +
                tree.findLCA(4, 6).data);
        System.out.println("LCA(3, 4) = " +
                tree.findLCA(3, 4).data);
        System.out.println("LCA(2, 4) = " +
                tree.findLCA(2, 4).data);
    }

}

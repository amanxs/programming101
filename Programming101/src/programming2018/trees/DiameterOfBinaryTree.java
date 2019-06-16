package programming2018.trees;

public class DiameterOfBinaryTree {


    static class Node{

        int data;
        Node left, right;

        public Node(int item){
            data = item;
            left = right = null;
        }
    }


    Node root;

    private int diameter(Node root){

    /*base case if tree is empty*/
    if(root == null )
        return 0;

    int lHeight = height(root.left);
    int rHeight = height(root.right);

    int lDiameter = diameter(root.left);
    int rDiameter= diameter(root.right);

    return Math.max(lHeight + rHeight +1, Math.max(lDiameter, rDiameter));
    }

    /* A wrapper over diameter(Node root) */
    int diameter()
    {
        return diameter(root);
    }

    /*The function Compute the "height" of a tree. Height is the
      number of nodes along the longest path from the root node
      down to the farthest leaf node.*/
    static int height(Node node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;

        /* If tree is not empty then height = 1 + max of left
           height and right heights */
        return (1 + Math.max(height(node.left), height(node.right)));
    }


    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        //System.out.println("The diameter of given binary tree is : "
                //+ tree.diameter());
    }
}

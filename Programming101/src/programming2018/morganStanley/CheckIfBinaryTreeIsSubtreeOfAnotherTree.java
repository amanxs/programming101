package programming2018.morganStanley;

// One solution is just check for the root node of child tree in parent tree and check if identical.
// This will work only in case if there are no identical elements.
public class CheckIfBinaryTreeIsSubtreeOfAnotherTree {

    class Node{
        Node left;
        Node right;
        int data;

        Node(int d){
            data= d;
            left=right=null;
        }
    }


    static boolean areIdentical(Node root1, Node root2){

        if(root1==null && root2==null)
            return true;

        else if(root1==null || root2==null)
            return false;

        return root1.data==root2.data
                && areIdentical(root1.left,root2.left)
                && areIdentical(root1.right, root2.right);
    }

    // When given the tree is BST
    static boolean isSubtree(Node parent, Node child){

        Node node = getNode(parent, child.data);

        if(null!=node)
            return areIdentical(node,child);

        return false;
    }

    private static Node getNode(Node parent, int data) {
        if(parent.data==data)
            return parent;

        else if(data>parent.data)
            return getNode(parent.right,data);

        else
            return getNode(parent.left,data);
    }



    static boolean isSubtreeBinaryTree(Node parent, Node child){

        if(child==null)
            return true;

        if(parent==null)
            return false;

        if(areIdentical(parent,child))
            return true;

        return isSubtreeBinaryTree(parent.left,child)
                || isSubtreeBinaryTree(parent.right, child);
    }


    static Node searchNodeInBinaryTree(Node parent, int data){

        if(parent.data==data)
            return parent;

            Node left = searchNodeInBinaryTree(parent.left,data);

            if(left!=null)
                return left;

            Node right = searchNodeInBinaryTree(parent.right, data);

            if(right!=null)
                return right;

            return null;

    }
}

package programming2020;

public class LcaBinaryTree {
    Node root;

    static class Node {
        Node left;
        Node right;
        int data;
        Node(int d){
            data =d;
        }
    }

    /**
     * The idea is to traverse the tree starting from root.
     * If any of the given keys (n1 and n2) matches with root, then root is LCA (assuming that both keys are present).
     * If root doesn’t match with any of the keys, we recur for left and right subtree.
     * The node which has one key present in its left subtree and the other key present in right subtree is the LCA.
     * If both keys lie in left subtree, then left subtree has LCA also, otherwise LCA lies in right subtree.
     * @param node
     * @param n1
     * @param n2
     * @return
     */
    public Node lca(Node node, int n1, int n2) {

        if(node == null) {
            return null;
        }

        if(node.data == n1 || node.data == n2) {
            return node;
        }

        Node left = lca(node.left, n1, n2);
        Node right = lca(node.right, n1, n2);

        if(left != null && right!= null){
            return node;
        }

        return left!=null ? left : right;
    }

    public Node findLCA(int n1, int n2) {
        return lca(root, n1, n2);
    }

    public static void main(String[] args) {
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


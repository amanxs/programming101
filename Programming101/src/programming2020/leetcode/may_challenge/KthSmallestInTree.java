package programming2020.leetcode.may_challenge;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestInTree {
        TreeNode root;
        static List<TreeNode> list = new ArrayList<>();
        public int kthSmallest(TreeNode root, int k) {
            inorderTraversal(root);

            int e = list.get(k-1) !=null ? list.get(k-1).val : -1;

            return e;
        }

        public void inorderTraversal(TreeNode node){
            if(null == node){
                return;
            }
            inorderTraversal(node.left);
            list.add(node);
            inorderTraversal(node.right);
        }

    void printInorder(TreeNode node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.val + " ");
        list.add(node);

        /* now recur on right child */
        printInorder(node.right);
    }
    void printInorder()    {     printInorder(root);   }
    void kthSmallest()    {     kthSmallest(root,1);   }

    public static void main(String[] args)
    {
        KthSmallestInTree tree = new KthSmallestInTree();
        tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(1);
        tree.root.right = new TreeNode(4);
        tree.root.left.right = new TreeNode(2);

        //System.out.println("\nInorder traversal of binary tree is ");
        tree.kthSmallest();
        for(TreeNode e : list){
            System.out.println(e.val);
        }
    }
}

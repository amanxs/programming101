public class LcaDeepestLeaves {

     //Definition for a binary tree node.
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    int deepest = 0;
    TreeNode res;
    public TreeNode lcaDeepestLeaves(TreeNode root) {

        helper(root, 0);
        return res;
    }

    public int helper(TreeNode node, int depth){
        // compare upfront
        deepest = Math.max(deepest, depth); // update the depth upfront.

        if (node == null)
            return depth;

        int left = helper(node.left, depth + 1); // note add one to the depth
        int right = helper(node.right, depth + 1);

        // now if both are deepest, basically leaves, their parent can be set to the res
        if (left == deepest && right == deepest)
            res = node;

        // return max depth between left and right subtree
        return Math.max(left, right);
    }
}

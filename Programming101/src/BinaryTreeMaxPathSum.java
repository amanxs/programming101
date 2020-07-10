public class BinaryTreeMaxPathSum {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int max;
    public int maxPathSum(TreeNode root) {
        if(null == root) return 0;
        max = root.val;
        dfs(root);
        return max;
    }

    public int dfs(TreeNode node){
        if(node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        int val = left + right + node.val;
        max = Math.max(Math.max(max, val), Math.max(left, right) + node.val);
        return Math.max(node.val, node.val + Math.max(right, left));
    }
}

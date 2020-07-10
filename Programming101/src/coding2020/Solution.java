package coding2020;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
//     Map<Integer, Integer> depth;
//     Map<Integer, TreeNode> parent;

//     public boolean isCousins(TreeNode root, int x, int y) {
//         depth = new HashMap();
//         parent = new HashMap();
//         dfs(root, null);
//         return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
//     }

//     public void dfs(TreeNode node, TreeNode par) {
//         if (node != null) {
//             depth.put(node.val, par != null ? 1 + depth.get(par.val) : 0);
//             parent.put(node.val, par);
//             dfs(node.left, node);
//             dfs(node.right, node);
//         }
//     }

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        queue.add(root);
        map.put(root.val, 0);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (areSiblings(x, y, left, right)) return false;
            if(left != null){
                queue.add(left);

                map.put(left.val, node != null ? map.get(node.val) + 1 : 0);


            }
            if(right != null){
                queue.add(right);
                map.put(right.val, node != null ? map.get(node.val) + 1 : 0);

            }


        }
        return (map.get(x) == map.get(y)) ? true : false;

    }

    private boolean areSiblings(int x, int y, TreeNode left, TreeNode right) {
        if(left !=null && right != null){
            if((left.val == x && right.val== y) || left.val == y && right.val == x ){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
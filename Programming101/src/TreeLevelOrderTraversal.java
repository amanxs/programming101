import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLevelOrderTraversal {


    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //O(n) time, because you go through all the nodes in a tree.
    //O(n) space, because in the worst case there is roughly n/2 nodes in the queue which comes down to O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> result = new LinkedList();

        if(root == null)
            return result;

        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList();
            //you can add a list directly like this
            result.add(list);

            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                list.add(curr.val);

                if(curr.left!=null)
                    queue.offer(curr.left);

                if(curr.right!=null)
                    queue.offer(curr.right);
            }
        }

        return result;
    }
}

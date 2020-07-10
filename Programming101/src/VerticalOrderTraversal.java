import java.util.*;

public class VerticalOrderTraversal
{
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        class Node implements Comparable {
            int val;
            int y;

            Node(int val, int y) {
                this.val = val;
                this.y = y;
            }


            @Override
            public int compareTo(Object o) {
                return 0;
            }

            // @Override
            // public int compareTo(VOpair2 o) {
            // return (this.hl == o.hl) ? this.val - o.val : this.hl - o.hl;
        }


        //Map<Integer, List<int[]>> map;
        HashMap<Integer, List<int[]>> map = new HashMap<>();

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            //map = new HashMap<>();
            dfs(root, 0, 0);
            List<Integer> keys = new ArrayList<Integer>(map.keySet());
            Collections.sort(keys);

            List<List<Integer>> res = new LinkedList<>();
            for (int key : keys) {
                List<int[]> list = map.get(key);
                //Collections.sort(list, (a,b) -> a[2] -b[2]);
                Collections.sort(list, (a, b) -> (b[2] == a[2] ? a[0] - b[0] : a[2] - b[2]));
                List<Integer> ans = new LinkedList<>();
                for (int[] e : list) {
                    ans.add(e[0]);
                }
                res.add(ans);

            }
            return res;
        }

        public void dfs(TreeNode node, int x, int y) {
            if (node == null) return;
            map.computeIfAbsent(x, L -> new ArrayList<>()).add(new int[]{node.val, x, y});
            dfs(node.left, x - 1, y + 1);
            dfs(node.right, x + 1, y + 1);

        }
    }
}

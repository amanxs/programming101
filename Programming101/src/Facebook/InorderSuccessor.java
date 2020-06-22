package Facebook;

public class InorderSuccessor {

     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
            return succ(root, p, null);
        }

        public TreeNode succ(TreeNode root, TreeNode p, TreeNode parent){
            if(root.val == p.val){
                if(null != root.right){
                    TreeNode curr = root.right;
                    while(null != curr.left){
                        curr = curr.left;
                    }
                    return curr;
                }
                return parent;
            }
            else if(root.val > p.val){
                return succ(root.left, p, root);
            }

            else{
                return succ(root.right, p, parent);
            }
        }
    /**
     * Below approach is to do an inorder traversal and store the successor which will run in O(n) time
     * and the above approach will run in O(H) time which will traverse the height of the tree.
     */

    // boolean found = false;
        // TreeNode prev = null;
        // public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //     if(root == null) return null;
        //     TreeNode left = inorderSuccessor(root.left, p);
        //     if(prev !=null && prev.val == p.val){
        //         return root;
        //     }
        //     System.out.println(root.val);
        //     prev = root;
        //     TreeNode right = inorderSuccessor(root.right, p);
//         Stack<TreeNode> stack = new Stack<TreeNode>();
//         TreeNode curr = root;
//         while(curr != null || stack.size()>0){
//             while(curr != null){
//                 stack.push(curr);
//                 curr = curr.left;

//             }
//             curr = stack.pop();
//             if(found){
//                 return curr;
//             }
//             if(curr.val == p.val){
//                 found = true;
//             }
//             curr = curr.right;
//         }

//         for(int i =0; i< list.size(); i++){
//             TreeNode node = list.get(i);

//             if(list.get(i).val == p.val){
//                 System.out.println(i);
//                 return i<list.size()-1 ? list.get(i+1) : null;
//             }
//         }



}

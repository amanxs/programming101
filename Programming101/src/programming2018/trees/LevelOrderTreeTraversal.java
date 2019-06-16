package programming2018.trees;

/**
 * Level order traversal of a tree is breadth first traversal for the tree.
 */
public class LevelOrderTreeTraversal {


    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    class BinaryTree {

        Node root;

        public BinaryTree()
        {
            root = null;
        }

 /*
 Compute the "height" of a tree -- the number of nodes along the longest path from the root node
 down to the farthest leaf node.
 */
        int height(Node root) {
            if (root == null)
                return 0;

            int lHeight = height(root.left);
            int rHeight = height(root.right);

            return 1 + Integer.max(lHeight, rHeight);

        }

        /**
         * Print nodes at the given level
         */

        void printGivenLevel(Node root, int level){

            if(level==1){
                System.out.print(root.data+"");
            }
            else if (level>2)
                printGivenLevel(root.left, level-1);
                printGivenLevel(root.right, level-1);
        }

        void printLevelOrder(){
            int h = height(root);

            for (int i =1;i<h; i++ )
                printGivenLevel(root, i);
        }
    }



}

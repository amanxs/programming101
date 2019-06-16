package programming2018.dataStructure.binaryTrees;

  class LevelOrderTraversal {

      static class Node{
          Node left, right;
          int data;
          Node(int d){
              data = d;
              left = right=null;
          }
      }
      private static class BinaryTree {
          Node root;

          public BinaryTree() {
              root = null;
          }

           void levelOrderTraversal() {
              int h = height(root);

              for (int i = 1; i <= h; i++) {
                  printGivenLevel(root, i);
              }
          }

          private static void printGivenLevel(Node root, int level) {

              if (root == null)
                  return;

              if (level == 1)
                  System.out.print(root.data + " ");

              else if (level > 1) {
                  printGivenLevel(root.left, level - 1);
                  printGivenLevel(root.right, level - 1);
              }
          }

          private static int height(Node root) {
              if (root == null)
                  return 0;
              else
                  return 1 + Math.max(height(root.left), height(root.right));
          }

      }
      //Driver program to test the above program

      public static void main(String args[]){
            BinaryTree  tree = new BinaryTree();
            tree.root = new Node(1);
            tree.root.left =  new Node(2);
            tree.root.right =  new Node(3);
            tree.root.left.left= new Node(4);
            tree.root.left.right= new Node(5);
            System.out.println("Level order traversal of binary tree is ");
            tree.levelOrderTraversal();
      }
  }

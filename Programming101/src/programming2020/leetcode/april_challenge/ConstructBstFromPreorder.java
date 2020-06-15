package programming2020.leetcode.april_challenge;

public class ConstructBstFromPreorder {
    int index =0;
    public class Node{
        int data;
        Node left;
        Node right;

        Node(int d){
            data = d;
            left = right = null;
        }
    }

    public Node bstFromPreorder(int[] preorder, int n) {
        createBst(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);

        return null;
    }
//
//
//    public Node createBst(int preorder[], int min, int max, int index){
//        if(preorder[index]<min || preorder[index]> max){
//            return null;
//        }
//        Node node = new Node(preorder[index]);
//        node.left = createBst(preorder,min, node.data, index+1);
//        node.right = createBst(preorder,node.data, max, index+1);
//
//        return node;
//    }

    public Node createBst(int preorder[], int min, int max){
        if(index >= preorder.length || preorder[index]<min || preorder[index]> max){
            return null;
        }

        Node node = new Node(preorder[index]);
        index++;
        node.left = createBst(preorder,min, node.data);
        node.right = createBst(preorder,node.data, max);

        return node;
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        ConstructBstFromPreorder tree = new ConstructBstFromPreorder();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        Node root = tree.bstFromPreorder(pre, size);
        System.out.println("Inorder traversal of the constructed tree is ");
        //tree.printInorder(root);
    }
}

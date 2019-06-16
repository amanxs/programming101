package programming2018.hackerRank.trees;

public class BinarySearchTree {

    static class Node {
        int data;
        Node left;
        Node right;
    }

   static Node insert(Node root, int value){
        Node newNode = new Node();
        newNode.data = value;
        Node n = root;

        if(root==null)
            return newNode;

        while(n!= null){
            if(n.data<value) {
                n = n.right;
            }
            if(n.data>value) {
                n = n.left;
            }
        }
        n = newNode;
        return root;

    }

    //Lowest common Ancestor of the input nodes
    static Node lca(Node root,int v1,int v2)
    {
        Node n = root;
        while(n!=null) {
            if (n.data > v1 && n.data > v2)
                n = n.left;
            else if (n.data < v1 && n.data < v2)
                n = n.right;
            else
                break;
        }
        return n;

        //nodeIsBetwwen(n, v1, v2);

    }

    private static boolean nodeIsBetwwen(Node n, int v1, int v2) {
       if(v1>v2){
           return (v1> n.data && n.data > v2);
       }
       else{
           return (v2>n.data && n.data > v1);
       }
    }

    void huffmanDecoding(String s, Node root){
       char arr[]= s.toCharArray();
       Node n = root;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]=='0'){
                n=n.left;
                if(n.left==null){
                    System.out.print(n.data);
                    n=root;
                }

            }
            else  if(arr[i] == '1'){
                n = n.right;
                if(n.right==null){
                    System.out.print(n.data);
                    n=root;
                }
            }
        }
    }

    //Solution
    void decode(String str, Node root) {
        Node n = root;
        for (int i = 0; i < str.length(); i++) {
            n = (str.charAt(i) == '0') ? n.left : n.right;
            if (n.left == null && n.right == null) {
                System.out.print(n.data);
                n = root;
            }
        }
    }


    boolean checkBST(Node root) {

        Node node = root;

        if(node==null)
            return true;

        else if((node.left!=null && node.left.data>node.data) || (node.right!=null &&node.right.data<node.data))
            return false;

        else
            return checkBST(root.left) && checkBST(root.right);
    }

    //The above method is wrong.'
    /*For each node, check if max value in left subtree is smaller than the node
      and min value in right subtree greater than the node.
      A better solution looks at each node only once.

      The trick is to write a utility helper function isBSTUtil(struct node* node, int min, int max)
      that traverses down the tree keeping track of the narrowing min and max allowed values as it goes,
      looking at each node only once.
    */

    boolean checkBST(Node node, int min, int max) {
        if(node==null)
            return true;

        if (node.data < min || node.data > max)
            return false;

        return checkBST(node.left,min, node.data-1) && checkBST(node.right, node.data+1, max);

    }

    }

package programming2018.dataStructure;

public class BinaryTree {


    static class Node<T>{

        T data;
        Node left, right;

        Node(T item){
            data = item;
        }
    }


    static class Tree{

        Node root;

        Tree(int data){
            root = new Node(data);
        }

        Tree (){
            root = null;
        }
    }


    public static void main(String args[]){
        Tree binaryTree = new Tree();
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node (3);

        binaryTree.root.left.left = new Node(4);

        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
       */
    }
}

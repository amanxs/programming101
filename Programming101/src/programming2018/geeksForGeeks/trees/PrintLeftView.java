package programming2018.geeksForGeeks.trees;

public class PrintLeftView {

    class Node{
        int data;
        Node left;
        Node right;

        Node(int d){
            data = d;
            left=right=null;
        }
    }

    static void printLeftView(Node head){
        int h = height(head);
        Node node = head;
        System.out.println(node.data);

        for (int i = 1; i <= h; i++) {
            node = node.left;
            if (node == null)
                node = node.right;

            System.out.println(node.data);
        }
    }

    static void printLeftViewRecursive(Node node){
        leftViewUtil(node, 1);
    }

    static void leftViewUtil(Node node, int l){
        if(node==null)
            return;

        leftViewUtil(node.left, l+1);
    }


    static int height(Node node){

        if(node==null)
            return 0;

        return  1 + Math.max(height(node.left), height(node.right));
    }
}

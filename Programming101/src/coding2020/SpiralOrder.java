package coding2020;

import java.util.Stack;

public class SpiralOrder {

    static class Node{
        int d;
        Node left;
        Node right;
        Node(int data){
            this.d = data;
            left = null;
            right= null;
        }
    }

    public static void traverse(Node node){
        //Queue<Integer> q = new LinkedList<Integer>();

        Stack<Node> stack = new Stack<Node>();
        Stack<Node> reverse = new Stack<Node>();
        stack.push(node);
        while(!stack.isEmpty() || !reverse.isEmpty()){
            while (!stack.isEmpty()) {
                Node curr = stack.pop();
                System.out.println(curr.d);

                if (curr.left != null) reverse.push(curr.right);
                if (curr.right != null) reverse.push(curr.left);
            }
            while (!reverse.isEmpty()) {
                Node curr = reverse.pop();
                System.out.println(curr.d);

                if (curr.left != null) stack.push(curr.left);
                if (curr.right != null) stack.push(curr.right);
            }
        }
            //1
       //2       //3
   //4  //5     //6  //7
    }

    public static void main(String[] args) {
    Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        traverse(root);
    }
}


//----Emplpoyee
//        name and id
//
//Department
//        deptId and
//
//1 emp in many dept;
//1 dept has many employees
//
//emp id dept id
//1          1
//2           2
//3           1
//2           3
//2
//
//
//
// 2
// 2
// 2
//name of all the employess working in the 3 dept 1 2 3
//
//select count(*), empid from table group by empId ;
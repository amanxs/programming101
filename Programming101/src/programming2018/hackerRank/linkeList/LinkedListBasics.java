package programming2018.hackerRank.linkeList;

public class LinkedListBasics {

    static Node head;


    static class Node{
        Node next;
        Node prev;//optional for functions pertaining to doubly linked list

        int data;
        Node(int d) {
            data = d;
            next = null;
        }
        Node(){

        }

    }

    static void Print(Node head){

        Node n = head;

        while(n!=null){
            System.out.println(n.data);
            n = n.next;
        }

    }

    Node Insert(Node head,int data) {
        Node n = new Node();
        n.data = data;
        n.next = null;

        if(head == null){
            head = n;
            return head;
        }

        else {
            Node c = head;
            while(c.next != null){
                c = c.next;
            }
            c.next = n;
            return head;

        }

    }


    Node InsertNth(Node head, int data, int position) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        Node n = new Node();
        n.data = data;
        if(position ==0){
            n.next = head;
            return n;
        }
        else{
            Node node = head;

            for(int i=0; i<position-1 ; i++){
                node = node.next;
            }

            n.next = node.next;
            node.next = n;
            return head;
        }
    }

    void ReversePrint(Node head) {
        // This is a "method-only" submission.
        // You only need to complete this method.
            while(head!=null){
                ReversePrint(head.next);
                System.out.println(head.data);
            }
    }

    Node Reverse(Node node) {
        Node current = node;
        Node next = null;
        Node prev = null;

        while(current!=null){
            next = current.next;
            current.next =prev;
            prev = current;
            current = next;
        }

        return current;
    }

    static Node mergeLists(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method
        Node h = headA;
        Node k = headB;

        if(h==null) return k;
        else if(k==null) return h;
        else{

            Node head = null;
            if (h.data < k.data) {
                head = h;
                h = h.next;
            } else {
                head = k;
                k = k.next;
            }


            Node node = head;
            while(h!=null || k!= null){
                if(h==null || (k!=null && h.data>k.data)) {
                    node.next = k;
                    k = k.next;
                }
                else{
                    node.next = h;
                    h= h.next;
                }
                node = node.next;
            }
            return head;
        }

    }


    public static void main(String[] args) {
        LinkedListBasics list = new LinkedListBasics();
        list.head = new Node(1);
        list.head.next = new Node(3);
        list.head.next.next = new Node(5);
        list.head.next.next.next = new Node(6);


        LinkedListBasics list2 = new LinkedListBasics();
        list2.head = new Node(2);
        list2.head.next = new Node(4);
        list2.head.next.next = new Node(7);



        System.out.println("Original Linked list ");
        Node n=list2.mergeLists(list.head, list2.head);
        Print(n);
    }

    /*
  Get Nth element from the end in a linked list of integers
  Number of elements in the list will always be greater than N.
  Node is defined as
  class Node {
     int data;
     Node next;
  }
*/

    int GetNode(Node head,int n) {
        // This is a "method-only" submission.
        // You only need to complete this method.

        Node node = head;
        Node position = head;
        for (int i = 0; i <n ; i++) {
            node = node.next;
        }
        while(node!=null){
            position  = position.next;
            node = node.next;
        }

        return position.data;
    }

    boolean hasCycle(Node node){
        if(head==null)
            return false;
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            //if there is a cycle the fast node will keep looping around and passing through the same node
            //which will ultimately result in collision
            if(slow==fast)
                return true;
        }
        return false;
    }

    int FindMergeNode(Node headA, Node headB) {
        // Complete this function
        // Do not write the main method.

        Node n1 = headA;
        Node n2 = headB;

        while(n1!=n2){
            if(null==n1.next)
                n1=headB;
            else
                n1 = n1.next;

            if(null==n2.next)
                n2=headA;
            else
                n2=n2.next;

        }

        return n1.data;

    }


    Node SortedInsert(Node head,int data) {
        Node new_node = new Node();
        new_node.data = data;

        if(head==null)
            return new_node;
        else if(data<head.data){
            new_node.next = head;
            head.prev = new_node;
            return new_node;
        }
        else{
            Node n1 = head;
            Node n2 = null;

            while(n1!= null && data>n1.data) {
                n2 = n1;
                n1 =n1.next;
            }

            n2.next = new_node;
            new_node.prev = n2;

            if(n1!=null){
                new_node.next = n1;
                n1.prev = new_node;
            }

        }


        return head;
    }

    Node ReverseDoublyLinkedList(Node head) {
        Node node = head;
        Node last = null;
        while(node!= null){

            Node next = node.next;
            node.next = node.prev;
            node.prev = next;
            if(next== null)
                last = node;

            node = next;
        }
        return last;
    }


}

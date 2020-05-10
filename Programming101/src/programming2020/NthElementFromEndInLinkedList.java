package programming2020;

public class NthElementFromEndInLinkedList {

    Node head = null;

    class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
        }
    }

    public void getNthElementFromEnd( int n){
        Node first = head;
        Node second = head;

        for(int i=1; i<n; i++){
            first = first.next;
        }

        while(first.next != null){
            first = first.next;
            second = second.next;
        }
        System.out.println(second.data);
    }

    public void push(int e){
        Node node = new Node(e);
        node.next = head;
        head = node;
    }

    public static void main(String args[]){
        NthElementFromEndInLinkedList linkedList = new NthElementFromEndInLinkedList();
        for (int i = 1; i <= 7 ; i++) {
            linkedList.push(i);
        }
        linkedList.getNthElementFromEnd(2);
    }
}

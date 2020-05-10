package programming2020;

/**
 * Given a singly linked list, find middle of the linked list. For example, if given linked list is 1->2->3->4->5 then output should be 3.
 * If there are even nodes, then there would be two middle nodes, we need to print second middle element.
 * For example, if given linked list is 1->2->3->4->5->6 then output should be 4.
 */
public class PrintMiddleInLinkedList {
    static Node head;

    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
        }
    }
    public static void main(String args[]){
        PrintMiddleInLinkedList list = new PrintMiddleInLinkedList();
        for (int i = 1; i <= 6 ; i++) {
            list.push(i);
        }
        printMiddle(head);
    }

    public static void push(int new_data) {
        Node node = new Node(new_data);
        node.next = head;
        head = node;
    }

    public static void printMiddle(Node head){

        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast.next != null && fast.next.next ==null){
            slow = slow.next;
        }

        System.out.println(slow.data);
    }
}

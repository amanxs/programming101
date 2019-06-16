package programming2019.geeksForGeeks.mustDoCodingQuestions.linkedList;

public class ReverseLinkedList {

    static Node head;

    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
        }
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        //123456
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);
        list.head.next.next.next.next.next.next.next = new Node(8);

        Node node = reverse(head);

        printList(node);

    }

    private static Node reverse(Node head) {
        Node node = head;

        while(node.next!=null){
            Node prev = node;
            Node next = node.next;
            next.next= prev;
            node = next;
        }
        head = node;

        return head;

    }
}

package programming2018.crackingTheCodingInterview.linkedList;

public class PartitionListAroundAValue {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }

    }

    /*Write code to partition a linked list around a value x,
    such that all nodes less than x come before all nodes greater than or equal to x.
     */
    static Node partitionAtX(Node head, int x) {
        Node node1 = null;
        Node node2 = null;

        Node nodeJoiner =null;

        Node node = head;

        head = null;

        while (node != null) {
            if (node.data < x) {
                if (node1 == null){
                    node1 = node;
                    head = node1;
                }
                else {
                    node1.next = node;
                    node1 = node1.next;
                }
            } else if (node.data > x) {
                if (node2 == null) {
                    node2 = node;
                    nodeJoiner = node2;
                }
                else {
                    node2.next = node;
                    node2 = node2.next;
                }
            }
            node = node.next;
        }

        if(head==null)
            return nodeJoiner;

             /* Merge before list and after list */
        node1.next = nodeJoiner;
        return head;

    }
}

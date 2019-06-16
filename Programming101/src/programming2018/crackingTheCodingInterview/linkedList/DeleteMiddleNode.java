package programming2018.crackingTheCodingInterview.linkedList;

public class DeleteMiddleNode {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }

    }


    /**
     * Delete a node from middle, given only access to that node
     */
    static void deleteMiddle(Node middle){
        if(middle==null)
            return;
        if (middle.next==null)
            middle=null;

        Node next = middle.next;
        middle.data = next.data;
        middle.next = next.next;
    }

}

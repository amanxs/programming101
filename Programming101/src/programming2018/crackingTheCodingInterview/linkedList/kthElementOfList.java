package programming2018.crackingTheCodingInterview.linkedList;

public class kthElementOfList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }

    }


    /**
     * kth to last element of a Linked List
     */

    static Node getKthElement(Node head, int k){
        if (head==null)
            return null;

        Node n1= head;
        for(int i=1; i<k; i++){
            if(n1==null)
                return null;

            n1= n1.next;
        }
        Node n2 = head;
        while(n1!=null){
            n1= n1.next;
            n2 = n2.next;
        }

        return n2;
    }


}

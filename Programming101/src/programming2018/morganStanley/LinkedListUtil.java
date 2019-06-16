package programming2018.morganStanley;

public class LinkedListUtil {

    class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }

    //Swap Kth node from beginning with Kth node from end in a Linked List
    private static void swapKth(Node head, int k){
        Node n = head;
        int i=1;
        Node nk_prev = null;
        while(i<k){
            nk_prev=n;
            n =n.next;
            i++;
        }
        //n is the kth node
        Node nk = n;

        Node nlk = head;
        Node nlk_prev = null;
        while(n.next!=null){
            nlk_prev = n;
            n = n.next;
            nlk = nlk.next;
        }
        nk_prev.next = nlk;
        nlk_prev.next = nk;
        

        Node temp = nlk.next;
        nlk.next = nk.next;
        nk.next =temp;

    }
}

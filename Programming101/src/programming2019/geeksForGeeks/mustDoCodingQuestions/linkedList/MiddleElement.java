package programming2019.geeksForGeeks.mustDoCodingQuestions.linkedList;

/**
 * Given a singly linked list of N nodes. The task is to find middle of the linked list.
 * For example, if given linked list is 1->2->3->4->5 then output should be 3.
 *
 * If there are even nodes, then there would be two middle nodes, we need to print second middle element.
 * For example, if given linked list is 1->2->3->4->5->6 then output should be 4.


 */
public class MiddleElement {

    static  Node head;
    static class Node{
        Node next;
        int data;
        Node(int d){
            next=null;
            data=d;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);

        MiddleElement llist = new MiddleElement();
        for (int i=6; i>0; --i)
        {
            llist.push(i);
            llist.printList();
            llist.printMiddle();
        }
        int middle = printMiddle();
        System.out.println("Middle element : " + middle);
    }

    private static int printMiddle() {
        Node slow = head;
        Node fast =head;
        int count=1;
        while(fast.next!=null && fast.next.next!=null){

            fast = fast.next.next;
            slow = slow.next;
            count= count+ 2;
        }
        if(fast.next!=null)
            slow = slow.next;

        return slow.data;
    }


    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* This function prints contents of linked list
       starting from  the given node */
    public void printList()
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+"->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }
}

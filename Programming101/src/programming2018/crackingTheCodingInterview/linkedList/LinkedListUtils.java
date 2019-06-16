package programming2018.crackingTheCodingInterview.linkedList;

import java.util.HashMap;

public class LinkedListUtils {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }

    }
        // If buffer is allowed : Then using Hashmap
        static void removeDuplicatesFromUnsortedList(Node head){
            Node n = head;
            Node prev = null;
            HashMap<Integer,Boolean> map = new HashMap<Integer, Boolean>();
            while(n!=null){
                if(map.containsKey(n.data)){
                    prev.next = n.next;
                }
                 else{
                     map.put(n.data,true);
                    prev = n;
                }
                n = n.next;
            }
        }
        //The above solution takes 0(N) time, where N is the number of elements in the linked list.


        //When buffer is not allowed. This will take upto O(n^2).
        //If we don't have a buffer, we can iterate with two pointers: current which iterates through the linked list,
        // and runner which checks all subsequent nodes for duplicates.


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

        /*
        You have two numbers represented by a linked list, where each node contains a single digit.
        The digits are stored in reverse order,such that the 1's digit isa t the head

        7 -> 1 -> 6
        +
        5-> 9-> 2
         */

        // 617 +295


    /*
        FOLLOW UP
        Suppose the digits are stored in forward order. Repeat the above problem.
         */
        static Node addNumbers(Node head1, Node head2){
            Node node1 = head1;
            Node node2 = head2;
            Node node = null;
            Node head = null;
            Node result = null;
            int carry = 0;

            while(node1!=null || node2 != null){

                int d = carry;

                if(node1!=null)
                    d += node1.data;

                if(node2!=null)
                    d += node2.data;

                   node = new Node(d %10);
                   carry = (d>=10)? 1 : 0;


               if(head==null) {
                   head = node;
                   result = head;
               }
               else {
                   head.next = node;
                   head = head.next;
               }

               node1 = node1.next;
               node2 = node2.next;

            }
            return null;
        }

        /*
        For the Follow up Ques

         One list may be shorter than the other, and we cannot handle this "on the fly."
         For example, suppose we were adding (1 -> 2 -> 3 -> 4) and (5 -> 6 -> 7).
         We need to know that the 5 should be "matched" with the 2, not the 1.
         We can accomplish this by comparing the lengths of the lists in the beginning and padding the shorter list with zeros.

         */

}

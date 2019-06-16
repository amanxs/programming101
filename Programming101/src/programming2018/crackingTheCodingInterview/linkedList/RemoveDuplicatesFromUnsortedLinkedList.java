package programming2018.crackingTheCodingInterview.linkedList;

import java.util.HashMap;

public class RemoveDuplicatesFromUnsortedLinkedList {

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

}

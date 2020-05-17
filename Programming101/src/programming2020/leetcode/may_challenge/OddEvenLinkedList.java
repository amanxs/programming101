package programming2020.leetcode.may_challenge;

public class OddEvenLinkedList {

     // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

        public ListNode oddEvenList(ListNode head) {
            if(head==null) return null;
            else if(head.next == null ||head.next.next == null ){
                return head;
            }
            ListNode node = head.next;

            ListNode oddHead = head;//1
            ListNode evenHead = head.next;//2
            ListNode nextOdd = oddHead.next.next;//3
            ListNode nextEven = evenHead.next.next;//4
            oddHead.next = nextOdd;//1-3
            evenHead.next = nextEven;//2-4
            oddHead = nextOdd;//3
            evenHead = nextEven;//4

            while(oddHead != null && oddHead.next != null){
                nextOdd = oddHead.next.next;//5
                if(nextOdd == null){
                    oddHead.next = node;
                    return head;
                }
                nextEven = evenHead.next.next;//null
                oddHead.next = nextOdd;//1-3-5
                evenHead.next = nextEven;//2-4-null
                oddHead = nextOdd;//5
                evenHead = nextEven;//null
            }
            if(oddHead.next == null){
                oddHead.next = node;
            }
            return head;
        }


}

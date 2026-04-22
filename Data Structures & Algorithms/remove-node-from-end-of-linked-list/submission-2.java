/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       
       /*
            have two pointers -> first at the start, second n steps forward
            -> once second reaches the end, first will be at position requiring a node removal 

            -> prev node should then point to the next node
            -> instead of starting at the first node 
            we start at a dummy node 

       */

       ListNode dummy = new ListNode(0, head); 
       ListNode right = head; 
       ListNode left = dummy; 

       int count = 1;
       while(n>=count){
        right = right.next;
            count++;
       }

       while(right != null){
            left = left.next;
            right = right.next;
       }

       left.next = left.next.next; 
       return dummy.next;

    }
}

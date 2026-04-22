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
    public void reorderList(ListNode head) {

        /*
            [1,2,3,4,5] -> [1,5,2,4,3]

            [1,2,3,4,5] -> [1,2,3] [4,5]
                                    [5,4]
                            [1,5,2,4,3,null]
            Two pointers -> fast, slow 
            slow -> index 0, 
            fast -> index 1 
            fast -> moves 2 places
            slow -> moves 1 place
            fast -> ends of list, slow will be halfway 
            
            -> reversing the second list 
            first value in second list -> to previous value 
            so previous value -> points to null as it is the last value 
            
            Loop:
                store -> next value 
                move pointer to next value 
                change pointer to point to previous value

            
        */

        ListNode slow = head; 
        ListNode fast = head.next;


        while(fast != null && fast.next != null){
            fast = fast.next.next; 
            slow = slow.next;
        }

        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        while(second != null){
            ListNode temp = second.next;
            second.next = prev; 
            prev = second;
            second = temp;
        }


        ListNode first = head;
        second = prev;

        while(second != null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second; 
            second.next = tmp1;
            first = tmp1; 
            second = tmp2;
        }





    }
}

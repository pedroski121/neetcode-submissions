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
        List<ListNode> ls = new ArrayList<>();

        ListNode curr = head;
        while(curr != null){
            ls.add(curr);
            curr = curr.next;
        }

        int indexToRemove = ls.size() - n;

        if(indexToRemove == 0){
            return head.next;
        }

        ls.get(indexToRemove - 1).next = ls.get(indexToRemove).next;
        return head;

    }
}

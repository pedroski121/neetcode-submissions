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
        Create an array for the nodes 
        Add nodes to array 
        have a new listnode to keep track of where next node should be 
        have to pointers -> i & j 
        using the pointer -> nodes should be obtained from the array and their next value should be changed
        */

        List<ListNode> ls = new ArrayList<>();
        ListNode curr = head;
        while(curr != null){
            ls.add(curr);
            curr = curr.next;
        }

        int i = 0, j = ls.size() - 1;
        
        while(i < j){
            ls.get(i).next = ls.get(j);
            i++;
            if(i >= j){
               break;
            }
             ls.get(j).next = ls.get(i);
             j--;

        }
        ls.get(i).next = null; 
    }
}

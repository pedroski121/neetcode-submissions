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
            -> An array to keep track of nodes and rearrange them 
            -> pointers -> to change the next node in linked list 

        */

        List<ListNode> ls = new ArrayList<>();
        ListNode curr = head; 
        
        while(curr != null) {
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

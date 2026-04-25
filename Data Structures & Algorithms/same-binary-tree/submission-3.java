/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
       Stack<TreeNode> sP = new Stack<>();

       Stack<TreeNode> sQ = new Stack<>();

       sP.push(p);
       sQ.push(q);

       while(!sP.empty() && !sQ.empty()){
            TreeNode pNode = sP.pop();
            TreeNode qNode = sQ.pop();

            if(pNode == null && qNode == null){
                continue;
            }

            if(pNode == null || qNode == null || pNode.val != qNode.val){
                return false;
            }

            sP.push(pNode.left);
            sQ.push(qNode.left);
            sP.push(pNode.right);
            sQ.push(qNode.right);
       }
       return true;

    }
}

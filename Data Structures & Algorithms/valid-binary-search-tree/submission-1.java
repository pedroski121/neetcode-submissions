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
    public boolean isValidBST(TreeNode root) {
        Stack<Values> stack = new Stack<>();

        Values values = new Values(root, Long.MIN_VALUE, Long.MAX_VALUE);

        stack.push(values);

        while(!stack.empty()) {
            Values v = stack.pop();

            if(!(v.node.val > v.left && v.node.val < v.right)){
                return false;
            }

            if(v.node.left != null){
                Values v1 = new Values(v.node.left, v.left, v.node.val);
                stack.push(v1);
            }

            if(v.node.right != null){
                Values v2 = new Values(v.node.right, v.node.val, v.right);
                stack.push(v2);
            }
        }
        return true;
    }

    class Values {
        public TreeNode node;
        public long left;
        public long right;

        Values(TreeNode node, long left, long right) {
            this.node = node;
            this.left = left;
            this.right = right;
        }
    }
}

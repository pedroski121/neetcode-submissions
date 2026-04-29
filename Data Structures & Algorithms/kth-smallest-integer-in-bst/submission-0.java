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
    public int kthSmallest(TreeNode root, int k) {
     List<Integer> list = new ArrayList<>();

     Stack<TreeNode> stack = new Stack<>();

     stack.push(root);

     while(!stack.empty()){
        TreeNode node = stack.pop();

        list.add(node.val);

        if(node.left != null){
            stack.push(node.left);
        }

        if(node.right != null) {
            stack.push(node.right);
        }
     }

     list.sort(null);

     return list.get(k-1);
    }
}

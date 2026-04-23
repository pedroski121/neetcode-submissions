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
    public TreeNode invertTree(TreeNode root) {
        /*
            switch the position of the left <-> right nodes 
            each nodes should be visited only once
            BFS/DFS can be applied 
            DFS
            Initialize a stack to keep track of nodes on hold 
            add root node to stack 
            
        */

        if(root == null){
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()){
            TreeNode top = stack.pop();
            TreeNode temp = top.left;
            top.left = top.right;
            top.right = temp;
            if(top.left != null){
                stack.push(top.left);
            }
            if(top.right != null){
                stack.push(top.right);
            }
        }
        return root;


    }
}

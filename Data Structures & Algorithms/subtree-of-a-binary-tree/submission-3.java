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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null){
            return true;
        }
        if(root == null && subRoot != null){
            return false;
        }

        
        Stack<TreeNode> s = new Stack<>();

        s.push(root);

        while(!s.empty()){
            TreeNode node = s.pop();

            if(node.val == subRoot.val){
                boolean isSubRoot = sameTree(node, subRoot) || sameTree(node.left, subRoot) || sameTree(node.right, subRoot);
                if(isSubRoot){
                    return true;
                }
            } 
                if(node.left != null){
                    s.push(node.left);
                }
                 if(node.right != null){
                    s.push(node.right);
                }
            
        }
        return false;
    }

    public boolean sameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        } 

        if(p != null && q != null && p.val == q.val){
            return sameTree(p.left, q.left) && sameTree(p.right, q.right);
        } else {
            return false;
        }

        
    }
}

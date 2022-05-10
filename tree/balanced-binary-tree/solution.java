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
    class Height {
        int height;
    }
    
    public boolean isBalanced(TreeNode root) {
        Height height = new Height();
        
        boolean isBalanced = isBalancedRec(root, height);
        return isBalanced;
    }
    
    private boolean isBalancedRec(TreeNode root, Height height) {
        if(root == null) {
            height.height = 0;
            return true;
        }
        
        Height hL = new Height();
        Height hR = new Height();
        boolean l = isBalancedRec(root.left, hL);
        boolean r = isBalancedRec(root.right, hR);

        height.height = Math.max(hL.height, hR.height) + 1;
        
        if(Math.abs(hL.height - hR.height) >= 2) {
            return false;
        }
        
        return l && r;
    }
}
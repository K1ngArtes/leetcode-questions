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
    public boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right == null) {
            return true;
        }
        if(root.left == null && root.right != null) {
            return false;
        }
        if(root.left != null && root.right == null) {
            return false;
        }
        
        Queue<TreeNode> ql = new LinkedList<TreeNode>();
        ql.add(root.left);
        ArrayList<Integer> qlList = new ArrayList<Integer>();
        while(!ql.isEmpty()) {
            TreeNode n = ql.remove();
            if(n == null) {
                qlList.add(null);
                continue;
            }
            qlList.add(n.val);
            ql.add(n.left);
            ql.add(n.right);
        }
        
        Queue<TreeNode> qr = new LinkedList<TreeNode>();
        qr.add(root.right);
        ArrayList<Integer> qrList = new ArrayList<Integer>();
        while(!qr.isEmpty()) {
            TreeNode n = qr.remove();
            if(n == null) {
                qrList.add(null);
                continue;
            }
            qrList.add(n.val);
            qr.add(n.right);
            qr.add(n.left);
        }
        
        if(qrList.size() != qlList.size()) {
            return false;
        }
        
        for(int i = 0; i < qrList.size(); i++) {
            if(qrList.get(i) != qlList.get(i)) {
                return false;
            }
        }
        
        return true;
    }
}
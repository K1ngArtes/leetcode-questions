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
        List<Integer> l1 = bfs(p);
        List<Integer> l2 = bfs(q);
        
        return l1.equals(l2);
    }
    
    private List<Integer> bfs(TreeNode p) {
        List<Integer> l1 = new ArrayList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(p);
        while(!q1.isEmpty()) {
            TreeNode n = q1.remove();
            if(n == null) {
                l1.add(null);
                continue;   
            }
            l1.add(n.val);
            q1.add(n.left);
            q1.add(n.right);
        }
        
        return l1;
    }
}
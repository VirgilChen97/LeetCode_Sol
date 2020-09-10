/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int res = 0;
    public int longestUnivaluePath(TreeNode root){
        if(root==null){
            return 0;
        }
        search(root,root.val);
        return res;
    }
    
    public int search(TreeNode root, int val) {
        if(root == null){
            return 0;
        }
        int l = search(root.left, root.val);
        int r = search(root.right, root.val);
        res= Math.max(res, l+r);
        if(root.val == val){
            return Math.max(l,r)+1;
        }
        return 0;
        
    }
}
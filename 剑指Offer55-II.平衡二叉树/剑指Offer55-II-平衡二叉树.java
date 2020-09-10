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
    public boolean isBalanced(TreeNode root) {
        return nodeBalance(root);
    }
    public boolean nodeBalance(TreeNode node){
        if(node == null){
            return true;
        }else{
            int sub = Math.abs(findDepth(node.left)-findDepth(node.right));
            if(sub > 1){
                return false;
            }else{
                return nodeBalance(node.left) && nodeBalance(node.right);
            }
        }
    } 
    
    public int findDepth(TreeNode p){
        if(p == null){
            return 0;
        }else{
            return Math.max(1 + findDepth(p.left),1 + findDepth(p.right));
        }
    }
}
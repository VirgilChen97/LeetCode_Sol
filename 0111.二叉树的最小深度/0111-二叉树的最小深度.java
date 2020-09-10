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
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else{
            return findpath(root);
        }
        
    }
    
    public int findpath(TreeNode node){
        if(node.left == null && node.right ==null){
            return 1;
        }else if(node.left != null && node.right ==null){
            return 1 + findpath(node.left);
        }else if(node.left == null && node.right !=null){
            return 1 + findpath(node.right);
        }else{
            return 1 + Math.min(findpath(node.left),findpath(node.right));
        }
    }
}
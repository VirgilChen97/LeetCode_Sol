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
    Integer prev = null;
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        search(root);
        return min;
    }

    public void search(TreeNode root){
        if(root == null){
            return;
        }
        search(root.left);
        if(prev!=null){
            min = Math.min(min, root.val - prev);
            prev = root.val;
        }else{
            prev = root.val;
        }
        search(root.right);
    }
}
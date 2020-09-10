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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return helper(root, limit, 0);
    }

    public TreeNode helper(TreeNode root, int limit, int sum){
        if(root == null){
            return null;
        }
        TreeNode left = helper(root.left, limit, sum + root.val);
        TreeNode right = helper(root.right, limit, sum + root.val);
        if(left == null && right == null){
            if(root.val + sum < limit){
                return null;
            }else if(root.left != null || root.right != null){
                return null;
            }
        }
        root.left = left;
        root.right = right;
        return root;
    }
}
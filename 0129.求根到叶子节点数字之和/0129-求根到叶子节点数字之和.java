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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    public void helper(TreeNode root, int val){
        if(root == null){
            return;
        }

        if(root.left != null){
            helper(root.left, (val + root.val)*10);
        }
        if(root.right != null){
            helper(root.right, (val + root.val)*10);
        }
        if(root.left == null && root.right == null){
            sum += val + root.val;
        }
    }
}
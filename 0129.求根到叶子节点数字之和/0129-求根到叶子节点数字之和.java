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
    int total = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        search(root, 0);
        return total;
    }
    public void search(TreeNode root, int sum){
        if(root.left == null && root.right == null){
            total += sum*10 + root.val;
        }
        if(root.left != null){
            search(root.left, sum*10 + root.val);
        }
        if(root.right != null){
            search(root.right, sum*10 + root.val);
        }
    }
}
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
    TreeNode prev = null;

    TreeNode wrongFirst = null;
    TreeNode wrongFirstNext = null;
    TreeNode wrongSecond = null;
    TreeNode wrongSecondNext = null;

    public void recoverTree(TreeNode root) {
        helper(root);
        if(wrongSecond != null){
            int temp = wrongFirst.val;
            wrongFirst.val = wrongSecondNext.val;
            wrongSecondNext.val = temp;
        }else{
            int temp = wrongFirst.val;
            wrongFirst.val = wrongFirstNext.val;
            wrongFirstNext.val = temp;
        }
    }

    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        helper(root.left);
        if(prev != null){
            if(prev.val > root.val){
                if(wrongFirst == null){
                    wrongFirst = prev;
                    wrongFirstNext = root;
                }else{
                    wrongSecond = prev;
                    wrongSecondNext = root;
                }
            }
        }
        prev = root;
        helper(root.right);
    }
}
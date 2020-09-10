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
    int smaller = Integer.MAX_VALUE;
    int small = Integer.MAX_VALUE;
    boolean hasSmall = false;
    boolean hasSmaller = false;
    public int findSecondMinimumValue(TreeNode root) {
        search(root);
        if(hasSmall){
            return small;
        }else{
            return -1;
        }
    }
    public void search(TreeNode root){
        if(root == null){
            return;
        }
        if(root.val < smaller || !hasSmaller){
            small = smaller;
            smaller = root.val;
            if(hasSmaller){
                hasSmall = true;
            }else{
                hasSmaller = true;
            }
        }else if((root.val < small || !hasSmall) && root.val!=smaller){
            small = root.val;
            hasSmall = true;
        }
        search(root.left);
        search(root.right);
    }
}
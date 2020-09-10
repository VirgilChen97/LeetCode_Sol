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
    int depth;
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return findDepth(root);
    }
    
    public int findDepth(TreeNode p){
        if(p == null){
            return 0;
        }else{
            return max2(1 + findDepth(p.left),1 + findDepth(p.right));
        }
    }
    
    public int max2(int p, int q){
        if(p > q){
            return p;
        }else{
            return q;
        }
    }
}
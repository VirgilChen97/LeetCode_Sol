import java.util.*;
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
    
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<TreeNode>();
        }else{
            return generate(1, n);
        }
    }
    public List<TreeNode> generate(int l, int r){
        List<TreeNode> res = new ArrayList<>();
        if(r < l){
            res.add(null);
            return res;
        }
        for(int i = l; i <= r; i++){
            List<TreeNode> lTrees = generate(l, i-1);
            List<TreeNode> rTrees = generate(i+1, r);
            for(TreeNode left:lTrees){
                for(TreeNode right:rTrees){
                    TreeNode current = new TreeNode(i);
                    current.left = left;
                    current.right = right;
                    res.add(current);
                }
            }
        }
        return res;
    }
}
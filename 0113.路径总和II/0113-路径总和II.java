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
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        helper(root, sum, new Stack<>());
        return res;
    }

    public void helper(TreeNode root, int sum, Stack<Integer> path){
        if(root == null){
            return;
        }else if(root.left == null && root.right == null){
            if(sum - root.val == 0){
                path.push(root.val);
                res.add(new ArrayList<>(path));
                path.pop();
            }
            return;
        }else{
            path.push(root.val);
            helper(root.left, sum - root.val, path);
            helper(root.right, sum - root.val, path);
            path.pop();
        }
    }
}
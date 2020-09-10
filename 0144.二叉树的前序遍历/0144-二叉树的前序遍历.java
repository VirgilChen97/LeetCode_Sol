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
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return res;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode now = stack.pop();
            res.add(now.val);
            if(now.right != null){
                stack.push(now.right);
            }
            if(now.left != null){
                stack.push(now.left);
            }
        }
        return res;
    }
}
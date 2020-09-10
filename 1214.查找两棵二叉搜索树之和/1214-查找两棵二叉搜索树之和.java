import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        dfs(root1);
        return dfs2(root2, target);
    }
    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        set.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }

    public boolean dfs2(TreeNode node, int target){
        if(node == null){
            return false;
        }
        if(set.contains(target - node.val)){
            return true;
        }else{
            return dfs2(node.left, target) || dfs2(node.right, target);
        }
    }
}
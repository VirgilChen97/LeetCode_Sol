import java.util.*;

class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(left + right > max){
            max = left + right;
        }
        return Math.max(left, right) + 1;
    }
}
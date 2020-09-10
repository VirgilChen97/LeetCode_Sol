import java.util.*;
class Solution {
    int prev = -1;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        search(root);
        return min;
    }

    public void search(TreeNode root){
        if(root == null){
            return;
        }
        search(root.left);
        if(prev != -1){
            int sub = root.val - prev;
            if(sub < min){
                min = sub;
            }
        }
        prev = root.val;
        search(root.right);
    }
}
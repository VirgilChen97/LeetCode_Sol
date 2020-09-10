import java.util.*;

class Solution {
    int sum = 0;
    public int findTilt(TreeNode root) {
        getTilt(root);
        return sum;
    }
    public int getTilt(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftsum = getTilt(root.left);
        int rightsum = getTilt(root.right);
        sum += Math.abs(leftsum - rightsum);
        return leftsum + rightsum + root.val;
    }
}
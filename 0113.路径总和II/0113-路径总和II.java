import java.util.*;

class Solution {
    List<Integer> now = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    public void pathSums(TreeNode root, int sum) {
        if(root == null){
            return;
        }
        if(sum - root.val == 0 && root.left == null && root.right == null){
            now.add(root.val);
            res.add(new ArrayList<Integer>(now));
            now.remove(now.size() - 1);
            return;
        }
        now.add(root.val);
        pathSums(root.left, sum - root.val);
        pathSums(root.right, sum - root.val);
        now.remove(now.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSums(root, sum);
        return res;
    }
}
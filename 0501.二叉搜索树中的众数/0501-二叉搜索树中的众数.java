import java.util.*;
class Solution {
    public List<Integer> res;
    TreeNode prev = null;
    int currentMax = 0;
    int count = 0;
    public int[] findMode(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        search(root);
        if(count > currentMax){
            currentMax = count;
            res = new ArrayList<>();
            res.add(prev.val);
        }else if(count == currentMax){
            res.add(prev.val);
        }
        int[] resInt = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resInt[i] = res.get(i);
        }
        return resInt;
    }

    public void search(TreeNode root){
        if(root == null){
            return;
        }
        search(root.left);
        if(prev == null || root.val == prev.val){
            count++;
            prev = root;
        }else{
            if(count > currentMax){
                currentMax = count;
                res = new ArrayList<>();
                res.add(prev.val);
            }else if(count == currentMax){
                res.add(prev.val);
            }
            count = 1;
            prev = root;
        }
        search(root.right);
    }
}
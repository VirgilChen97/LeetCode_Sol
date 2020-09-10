import java.util.*;

class Solution {
    List<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        search(root);
        int i=0, j = list.size()-1;
        while(i<j){
            if(list.get(i)+list.get(j)<k){
                i++;
            }else if(list.get(i)+list.get(j)==k){
                return true;
            }else{
                j--;
            }
        }
        return false;
    }
    public void search(TreeNode root){
        if(root == null){
            return;
        }
        search(root.left);
        list.add(root.val);
        search(root.right);
    }
}
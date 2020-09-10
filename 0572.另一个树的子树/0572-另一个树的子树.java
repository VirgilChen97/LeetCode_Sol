import java.util.*;

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null){
            return false;
        }
        if(compare(s, t)){
            return true;
        }else{
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

    public boolean compare(TreeNode s, TreeNode t){
        if(s == null && t ==null){
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        if(s.val != t.val){
            return false;
        }
        return compare(s.left, t.left) && compare(s.right, t.right);
    }
}
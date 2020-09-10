import java.util.*;

class Solution {
    public String tree2str(TreeNode t) {
        if(t == null){
            return "";
        }else if(t.left == null && t.right != null){
            return t.val + "()(" + tree2str(t.right) + ")";
        }else if(t.left != null && t.right == null){
            return t.val + "(" + tree2str(t.left) + ")";
        }else if(t.left == null && t.right == null){
            return t.val + "";
        }else{
            return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
        }
    }
}
import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindElements {
    TreeNode tree;
    public FindElements(TreeNode root) {
        root.val = 0;
        generate(root);
        tree = root;
    }
    
    public void generate(TreeNode root){
        if(root.left!=null){
            root.left.val = (root.val << 1) + 1;
            generate(root.left);
        }
        if(root.right!=null){
            root.right.val = (root.val << 1) + 2;
            generate(root.right);
        }
    }
    
    public boolean find(int target) {
        List<Boolean> list = new ArrayList<>();
        while(target>0){
            if((target & 1) == 0){
                list.add(true);
                target = target - 1;
                target >>= 1;
            }else{
                list.add(false);
                target >>= 1;
            }
        }
        TreeNode ptr = tree;
        for(int i = list.size()-1; i >=0; i--){
            if(list.get(i)){
                if(ptr.right != null){
                    ptr = ptr.right;
                }else{
                    return false;
                }
            }else{
                if(ptr.left != null){
                    ptr = ptr.left;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
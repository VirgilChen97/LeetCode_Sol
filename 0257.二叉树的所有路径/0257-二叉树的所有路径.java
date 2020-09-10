/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    List list = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        btp(root, "");
        return list;
    }
    
    public void btp(TreeNode root, String path){
        if(root == null){
            return;
        }
        if(root.left==null && root.right==null){
            path += root.val;
            list.add(path);
            return;
        }else{
            String now = root.val + "->";
            path += now;
            if(root.left!=null){
                btp(root.left, path);
            }
            if(root.right!=null){
                btp(root.right, path);
            }
        }
    }
}
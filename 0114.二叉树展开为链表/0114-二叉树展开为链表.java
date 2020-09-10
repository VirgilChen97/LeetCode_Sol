class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        TreeNode tempLeft = root.left;
        TreeNode tempRight = root.right;
        
        if(prev!=null){
            prev.left = null;
            prev.right = root;
        }
        prev = root;
        flatten(tempLeft);
        flatten(tempRight);
        
    }
}
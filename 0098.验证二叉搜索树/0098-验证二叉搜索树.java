class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean left = false;
        boolean right = false;
        left = isValidBST(root.left);
        if(prev != null){
            if(root.val <= prev.val){
                return false;
            }
        }
        prev = root;
        right = isValidBST(root.right);
        return left && right;
    }
}
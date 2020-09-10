class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return CreateTree(nums, 0, nums.length-1);
    }
    
    public TreeNode CreateTree(int []nums, int l, int r){
        if( l > r){
            return null;
        }
        if(l == r){
            return new TreeNode(nums[l]);
        }
        int m = (l+r)/2;
        TreeNode middle = new TreeNode(nums[m]);
        middle.left = CreateTree(nums, l, m-1);
        middle.right = CreateTree(nums, m+1, r);
        return middle;
    } 
}
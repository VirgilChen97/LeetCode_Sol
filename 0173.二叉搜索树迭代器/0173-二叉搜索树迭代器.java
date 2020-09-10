/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode root;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        this.root = root;
    }
    
    /** @return the next smallest number */
    public int next() {
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        int ans = root.val;
        root = root.right;
        return ans;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(root != null || !stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
import java.util.*;

class Solution {
    int inorder[];
    int postorder[];
    int index;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode build(int left, int right){
        if(left > right) return null;
        int now = postorder[index];
        int center = map.get(now);
        TreeNode root = new TreeNode(now);
        index--;
        root.right = build(center+1, right);
        root.left = build(left, center-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        index = inorder.length - 1;
        for(int i = 0; i < postorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(0, postorder.length - 1);
    }
}
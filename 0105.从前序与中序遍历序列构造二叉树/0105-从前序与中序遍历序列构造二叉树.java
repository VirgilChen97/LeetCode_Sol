import java.util.*;

class Solution {
    int inorder[];
    int preorder[];
    int index = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode build(int left, int right){
        if(left > right) return null;
        int now = preorder[index];
        int center = map.get(now);
        TreeNode root = new TreeNode(now);
        index++;
        root.left = build(left, center-1);
        root.right = build(center+1, right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for(int i = 0; i < preorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(0, preorder.length - 1);
    }
}
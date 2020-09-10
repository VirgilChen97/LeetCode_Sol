import java.util.*;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    List<TreeNode> res = new ArrayList<>();
    Set<Integer> toDelete = new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return res;
        }
        for (int delete : to_delete) {
            toDelete.add(delete);
        }
        if (!toDelete.contains(root.val)) {
            res.add(root);
        }
        del(root, null, false);
        return res;
    }

    public void del(TreeNode root, TreeNode parent, boolean side) {
        if (root == null) {
            return;
        }
        if (toDelete.contains(root.val)) {
            if (parent != null) {
                if (!side) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            if (root.left != null) {
                if (!toDelete.contains(root.left.val)) {
                    res.add(root.left);
                }
                del(root.left, root, false);
            }
            if (root.right != null) {
                if (!toDelete.contains(root.right.val)) {
                    res.add(root.right);
                }
                del(root.right, root, true);
            }
        } else {
            del(root.left, root, false);
            del(root.right, root, true);
        }
    }
}
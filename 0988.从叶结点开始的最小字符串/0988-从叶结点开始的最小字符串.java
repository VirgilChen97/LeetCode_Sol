import java.util.*;
import java.util.Map.Entry;

class Solution {
    public String min = null;

    public String smallestFromLeaf(TreeNode root) {
        helper(new StringBuilder(), root);
        return min;

    }

    public void helper(StringBuilder current, TreeNode node) {
        if (node.left == null && node.right == null) {
            current.insert(0, (char) (node.val + 'a'));
            if (min == null || current.toString().compareTo(min) < 0) {
                min = current.toString();
            }
            current.delete(0, 1);
        }

        if (node.left != null) {
            current.insert(0, (char) (node.val + 'a'));
            helper(current, node.left);
            current.delete(0, 1);
        }
        if (node.right != null) {
            current.insert(0, (char) (node.val + 'a'));
            helper(current, node.right);
            current.delete(0, 1);
        }
    }
}
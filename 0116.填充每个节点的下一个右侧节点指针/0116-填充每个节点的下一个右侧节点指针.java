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
class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Node left = root.left;
        Node right = root.right;
        while(left != null){
            left.next = right;
            left = left.right;
            right = right.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
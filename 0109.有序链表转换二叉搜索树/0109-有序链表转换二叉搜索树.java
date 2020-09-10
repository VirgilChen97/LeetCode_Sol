/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    ArrayList<Integer> list = new ArrayList<>();
    public TreeNode sortedListToBST(ListNode head) {
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        return build(0, list.size()-1);
    }
    public TreeNode build(int l, int r){
        if(l>r){
            return null;
        }
        int m = l + (r-l)/2;
        TreeNode now = new TreeNode(list.get(m));
        now.left = build(l, m -1);
        now.right = build(m+1, r);
        return now;
    }
}
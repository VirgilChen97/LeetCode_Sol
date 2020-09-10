/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode now = head;
        ListNode prev = null;
        while(now!=null){
            ListNode temp = now.next;
            now.next = prev;
            prev = now;
            now = temp;
        }
        return prev;
    }
}
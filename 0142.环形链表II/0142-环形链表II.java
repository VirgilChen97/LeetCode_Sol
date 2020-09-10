/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode meet = null;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                meet = fast;
                break;
            }
        }
        if(meet == null){
            return null;
        }else{
            while(head != fast){
                head = head.next;
                fast = fast.next;
            }
        }
        return fast;
    }
}
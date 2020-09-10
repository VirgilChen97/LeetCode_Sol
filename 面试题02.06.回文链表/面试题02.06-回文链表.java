/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reverse(slow.next);

        while(slow!=null){
            if(slow.val == head.val){
                slow = slow.next;
                head = head.next;
            }else{
                return false;
            }
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode now = head;
        ListNode next = head.next;
        while(now.next!=null){
            now.next = prev;
            prev = now;
            now = next;
            next = next.next;
        }
        now.next = prev;
        return now;
    }
}
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        while (head != null && head.next != null && head.val == head.next.val) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            head = head.next;
        }
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        } else {
            ListNode l = head;
            ListNode m = head.next;
            ListNode r = head.next.next;
            while (r != null) {
                if (m.val != r.val) {
                    l = l.next;
                    m = m.next;
                    r = r.next;
                } else {
                    while (r != null && r.val == m.val) {
                        r = r.next;
                    }
                    if (r == null) {
                        l.next = r;
                        return head;
                    } else {
                        l.next = r;
                        m = l.next;
                        r = m.next;
                    }
                }
            }
        }
        return head;
    }
}
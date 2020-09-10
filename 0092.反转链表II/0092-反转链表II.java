/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head.next == null || m == n){
            return head;
        }
        ListNode a = head;
        ListNode startLeft = null;
        for(int i = 0; i < m - 1; i++){
            if(i == m - 2){
                startLeft = a;
            }
            a =a.next;
        }
        ListNode startRight = a;
        ListNode EndLeft = null;
        ListNode b = a.next;
        ListNode c = b.next;
        for(int i = 0; i < n - m; i++){
            if(i == n - m - 1){
                EndLeft = b;
            }
            b.next = a;
            a = b;
            b = c;
            if(c!=null){
                c = c.next;
            }
        }
        ListNode EndRight = b;
        if(startLeft!=null){
            startLeft.next = EndLeft;
        }else{
            head = EndLeft;
        }
        startRight.next = EndRight;
        return head;
    }
}
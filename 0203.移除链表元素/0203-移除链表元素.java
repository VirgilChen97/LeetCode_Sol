/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode temp = new ListNode(val - 1);
        ListNode prev = temp;
        temp.next = head;
        while(head!=null){
            if(head.val == val){
                prev.next = head.next;
            }else {
                prev = prev.next;
            }head = head.next;
        }
        return temp.next;
    }
}
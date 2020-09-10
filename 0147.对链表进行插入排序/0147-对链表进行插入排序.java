/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode headdummy = new ListNode(0);
        headdummy.next = head;
        ListNode currentInsertion = head.next;
        ListNode lastOrdered = head;
        while(currentInsertion != null){
            ListNode ptr = headdummy;
            ListNode temp = currentInsertion.next;
            while(ptr != currentInsertion){
                if(ptr.next!=null && currentInsertion.val < ptr.next.val){
                    currentInsertion.next = ptr.next;
                    ptr.next = currentInsertion;
                    lastOrdered.next = temp;
                    break;
                }else{
                    ptr = ptr.next;
                }
            }
            if(ptr == currentInsertion){
                lastOrdered = lastOrdered.next;
            }
            currentInsertion = lastOrdered.next;
        }
        return headdummy.next;
    }
}
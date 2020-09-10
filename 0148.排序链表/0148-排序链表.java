/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null){
            return head;
        }
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode middled = middle.next;
        middle.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(middled);
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right){
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        while(left != null && right != null){
            if(left.val < right.val){
                ptr.next = left;
                ptr = ptr.next;
                left = left.next;
            }else{
                ptr.next = right;
                ptr = ptr.next;
                right = right.next;
            }
        }
        if(left != null){
            ptr.next = left;
        }
        if(right != null){
            ptr.next = right;
        }
        return head.next;
    }
    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
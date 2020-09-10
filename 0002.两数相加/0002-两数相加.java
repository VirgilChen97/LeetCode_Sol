/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            if(carry == 1){
                return new ListNode(1);
            }else{
                return null;
            }
        }
        if(l1 == null){
            return addTwoNumbers(new ListNode(0), l2);
        }
        if(l2 == null){
            return addTwoNumbers(new ListNode(0), l1);
        }
        int sum = l1.val + l2.val + carry;
        if(sum > 9){
            carry = 1;
        }else{
            carry = 0;
        }
        ListNode res = new ListNode(sum%10);
        res.next = addTwoNumbers(l1.next,l2.next);
        return res;
    }
}
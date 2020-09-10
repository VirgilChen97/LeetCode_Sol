/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        while(head!=null){
            list.add(head);
            head = head.next;
        }
        ListNode prev = null;
        for(int i = 0, j = list.size() - 1; i <= j; i++, j--){
            ListNode small = list.get(i);
            ListNode big = list.get(j);
            if(prev != null){
                prev.next = small;
            }
            if(i!=j){
                small.next = big;
            }
            prev = big;
        }
        if(prev != null){
            prev.next = null;
        }
    }
}
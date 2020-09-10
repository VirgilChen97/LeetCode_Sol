/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode head;
    int size = 0;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        ListNode curr = head;
        while(curr!=null){
            size++;
            curr = curr.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int position = (int)(Math.random() * size);
        ListNode curr = head;
        while(position > 0){
            curr = curr.next;
            position --;
        }
        return curr.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
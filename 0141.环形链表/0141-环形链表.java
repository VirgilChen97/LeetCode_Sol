import java.util.HashMap;
import java.util.Map;

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
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        Map map = new HashMap<ListNode,Integer>();
        while(map.get(head) == null && head.next !=null){
            map.put(head,0);
            head = head.next;
        };
        if(head.next==null){
            return false;
        }
        return true;
    }
}
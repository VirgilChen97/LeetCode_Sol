public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0;
        int lenB=0;
        int i = 0;
        ListNode headA2 = headA;
        ListNode headB2 = headB;
        
        while(headA2!=null){
            lenA++;
            headA2 = headA2.next;
        }
        while(headB2!=null){
            lenB++;
            headB2 = headB2.next;
        }
        
        if(lenA > lenB){
            while(i<lenA-lenB){
                i++;
                headA = headA.next;
            }
        }else{
            while(i<lenB-lenA){
                i++;
                headB = headB.next;
            }
        }

        while(headA!=null && headB!=null){
            if(headA==headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}
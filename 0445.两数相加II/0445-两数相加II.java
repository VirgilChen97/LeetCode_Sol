class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1len = 0;
        int l2len = 0;
        ListNode ptr = l1;
        while(ptr!=null){
            l1len++;
            ptr = ptr.next;
        }
        ptr = l2;
        while(ptr!=null){
            l2len++;
            ptr = ptr.next;
        }
        if(l1len > l2len){
            for(int i = 0; i < l1len - l2len; i++){
                ListNode zero = new ListNode(0);
                zero.next = l2;
                l2 = zero;
            }
        }else{
            for(int i = 0; i < l2len - l1len; i++){
                ListNode zero = new ListNode(0);
                zero.next = l1;
                l1 = zero;
            }
        }
        int inc = helper(l1, l2);
        if(inc == 1){
            ListNode one = new ListNode(1);
            one.next = l1;
            l1 = one;
        }
        return l1;
    }

    public int helper(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null){
            return 0;
        }
        int val = l1.val + l2.val + helper(l1.next, l2.next);
        if(val > 9){
            l1.val = val%10;
            return 1;
        }else{
            l1.val = val;
            return 0;
        }
    }
}
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if(head == null){
            return null;
        }
        if(head.child == null){
            flatten(head.next);
            return head;
        }else{
            Node next = head.next;
            Node ptr = head;

            Node flatChild = flatten(head.child);
            head.child = null;
            
            head.next = flatChild;
            flatChild.prev = head;

            while(ptr.next!=null){
                ptr = ptr.next;
            }

            if(next != null){
                Node flatNext = flatten(next);
                ptr.next = flatNext;
                flatNext.prev = ptr;
            }
            return head;
        }
    }
}
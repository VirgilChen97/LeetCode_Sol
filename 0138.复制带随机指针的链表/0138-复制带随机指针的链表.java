/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node ptr = head;
        Node res = new Node(0);
        Node resPtr = res;
        while(ptr!=null){
            if(map.containsKey(ptr)){
                resPtr.next = map.get(ptr);
            }else{
                resPtr.next = new Node(ptr.val);
                map.put(ptr, resPtr.next);
            }
            if(ptr.random!=null){
                if(map.containsKey(ptr.random)){
                    resPtr.next.random = map.get(ptr.random);
                }else{
                    resPtr.next.random = new Node(ptr.random.val);
                    map.put(ptr.random, resPtr.next.random);
                }
            }
            resPtr = resPtr.next;
            ptr = ptr.next;
        }
        return res.next;
    }
}
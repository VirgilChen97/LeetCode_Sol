/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node prev = null;
            int thisLevel = queue.size();
            for(int i = 0; i < thisLevel; i++){
                Node now = queue.poll();
                if(prev!=null){
                    prev.next = now;
                }
                prev = now;
                if(now.left != null){
                    queue.offer(now.left);
                }
                if(now.right != null){
                    queue.offer(now.right);
                }
            }
        }
        return root;
    }
}
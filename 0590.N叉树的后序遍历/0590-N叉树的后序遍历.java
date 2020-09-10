/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        post(root);
        return res;
    }
    public void post(Node root){
        if(root == null){
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            post(root.children.get(i));
        }
        res.add(root.val);
    }
}
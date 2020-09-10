/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    HashMap<Integer, Node> nodes = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(!nodes.containsKey(node.val)){
            Node copy = new Node();
            copy.val = node.val;
            List<Node> neighbors = new ArrayList<>();
            nodes.put(node.val, copy);
            for(Node childs:node.neighbors){
                neighbors.add(cloneGraph(childs));
            }
            copy.neighbors = neighbors;
            return copy;
        }
        else{
            return nodes.get(node.val);
        }
    }
}
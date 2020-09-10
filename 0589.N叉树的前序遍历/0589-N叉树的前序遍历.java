import java.util.*;

class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if(root == null){
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node current = stack.pop();
            res.add(current.val);
            if (current.children != null) {
                for(int i = current.children.size() - 1; i >= 0; i--) {
                    stack.push(current.children.get(i));
                }
            }
        }
        return res;
    }
}
import java.util.*;
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> thisLevel = new ArrayList<>();
            int numNodes = queue.size();
            for(int i = 0; i < numNodes; i++){
                TreeNode now = queue.poll();
                thisLevel.add(now.val);
                if(now.left != null){
                    queue.offer(now.left);
                }
                if(now.right != null){
                    queue.offer(now.right);
                }
            }
            res.add(thisLevel);
        }
        return res;
    }
}
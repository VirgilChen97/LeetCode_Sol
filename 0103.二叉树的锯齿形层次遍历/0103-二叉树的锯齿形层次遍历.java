import java.util.*;
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean switcher = false;
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> thisLevel = new LinkedList<>();
            int numNodes = queue.size();
            for(int i = 0; i < numNodes; i++){
                TreeNode now = queue.poll();
                if(switcher){
                    thisLevel.add(0, now.val);
                }else{
                    thisLevel.add(now.val);
                }
                if(now.left != null){
                    queue.offer(now.left);
                }
                if(now.right != null){
                    queue.offer(now.right);
                }
            }
            switcher =! switcher;
            res.add(thisLevel);
        }
        return res;
    }
}
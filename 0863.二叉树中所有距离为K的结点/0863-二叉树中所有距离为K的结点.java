import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, List<Integer>> g = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        g.put(root.val, new ArrayList<>());
        dfs(root, null);
       
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>(); 

        queue.add(target.val);
        int level = 0;
        for(; level < K; level++){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int now = queue.poll();
                visited.add(now);
                for(Integer child:g.get(now)){
                    if(!visited.contains(child)){
                        queue.add(child);
                    }
                }
            }
        }

        if(level == K){
            return (List)queue;
        }else{
            return new ArrayList<>();
        }
    }

    public void dfs(TreeNode root, TreeNode prev){
        if(prev != null){
            g.get(prev.val).add(root.val);
            g.get(root.val).add(prev.val);
        }

        if(root.left != null){
            g.put(root.left.val, new ArrayList<>());
            dfs(root.left, root);
        }

        if(root.right != null){
            g.put(root.right.val, new ArrayList<>());
            dfs(root.right, root);
        }
    }
}
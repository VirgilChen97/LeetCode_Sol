class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.offer(root);
        while (!treeQueue.isEmpty()){
            int levelSize = treeQueue.size();
            List<Integer> thisLevel = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = treeQueue.poll();
                thisLevel.add(current.val);
                if(current.left != null) treeQueue.offer(current.left);
                if(current.right != null) treeQueue.offer(current.right);
            }
            result.add(0, thisLevel);
        }
        return result;
    }
}
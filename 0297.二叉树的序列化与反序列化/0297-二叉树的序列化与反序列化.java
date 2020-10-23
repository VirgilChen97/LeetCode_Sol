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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode now = q.poll();
            if(now == null){
                sb.append("n");
                sb.append(" ");
            }else{
                sb.append(now.val);
                sb.append(" ");
                q.offer(now.left);
                q.offer(now.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(" ");

        if(arr[0].equals("n")){
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
        for(int i = 1; i < arr.length;){
            TreeNode p = q.poll();
            TreeNode r, l;
            if(!arr[i].equals("n")){
                l = new TreeNode(Integer.parseInt(arr[i++]));
                q.offer(l);
            }else{
                l = null;
                i++;
            }

            if(i < arr.length && !arr[i].equals("n")){
                r = new TreeNode(Integer.parseInt(arr[i++]));
                q.offer(r);
            }else{
                r = null;
                i++;
            }
            
            p.left = l;
            p.right = r;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
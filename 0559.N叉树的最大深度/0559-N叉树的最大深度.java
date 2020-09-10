import java.util.*;

class Solution {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int depthArr[] = new int[root.children.size()];
        for (int i = 0; i < root.children.size(); i++) {
            int depth = maxDepth(root.children.get(i));
            depthArr[i] = depth;
        }
        int max = 0;
        for(int current:depthArr){
            if(current > max){
                max = current;
            }
        }
        return max + 1;
    }
}
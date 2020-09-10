import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0){
            return new LinkedList<>();
        }
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> l1 = new LinkedList<>();
        l1.add(1);
        res.add(l1);
        if(numRows == 1) return res;

        for (int i = 1 ; i < numRows; i++){
            List<Integer> previous = res.get(i - 1);
            List<Integer> thisLevel = new LinkedList<>();
            thisLevel.add(1);
            for(int j = 0;j<previous.size()-1;j++){
                thisLevel.add(previous.get(j)+previous.get(j+1));
            }
            thisLevel.add(1);
            res.add(thisLevel);
        }

        return res;

    }
}
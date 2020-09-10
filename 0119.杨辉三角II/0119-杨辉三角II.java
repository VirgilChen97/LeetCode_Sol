import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        if(rowIndex == 0){
            return new LinkedList<>();
        }
        List<Integer> res = new LinkedList<>();
        res.add(1);
        if(rowIndex == 1) return res;
        int temp = 0;
        for (int i = 1 ; i < rowIndex; i++){
            res.add(1);
            for(int j = i - 1 ; j >= 0 ; j--){
                if(j == 0){
                    res.set(0,1);
                }else{
                    res.set(j,res.get(j)+res.get(j-1));
                }
            }
        }
        return res;

    }
}

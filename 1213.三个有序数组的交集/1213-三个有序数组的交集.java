import java.util.*;

class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for(int num:arr1){
            set.add(num);
        }
        for(int num:arr2){
            if(set.contains(num)){
                set2.add(num);
            }
        }
        for(int num:arr3){
            if(set2.contains(num)){
                res.add(num);
            }
        }
        return res;
    }
}
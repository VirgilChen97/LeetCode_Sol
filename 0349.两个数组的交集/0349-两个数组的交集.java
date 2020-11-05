import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();

        for(int a:nums1){
            set.add(a);
        }

        for(int b:nums2){
            if(set.contains(b)){
                res.add(b);
            }
        }

        int[] resArr = new int[res.size()];
        Iterator<Integer> it = res.iterator();
        for(int i = 0; i < resArr.length; i++){
            resArr[i] = it.next();
        }

        return resArr;
    }
}
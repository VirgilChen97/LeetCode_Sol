import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<Integer>();
        int i=0,j=0;
        while(i<nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }
        }
        int[] resArr = new int[res.size()];
        for (i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}
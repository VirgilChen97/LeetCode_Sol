import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet set = new HashSet<>();
        int i=0,j=0;
        while(i<nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                set.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }
        }
        int[] resArr = new int[set.size()];
        for (i = 0; i < set.size(); i++) {
            resArr[i] = (Integer)set.toArray()[i];
        }
        return resArr;
    }
}
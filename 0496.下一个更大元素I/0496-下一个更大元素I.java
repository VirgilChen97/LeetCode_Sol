class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for(int i = 0; i < nums1.length; i++){
            int position,j;
            for(position = 0; position < nums2.length; position++){
                if (nums2[position] == nums1[i]){
                    break;
                }
            }
            for(j = position+1; j < nums2.length; j++){
                if(nums1[i] < nums2[j]){
                    nums1[i] = nums2[j];
                    break;
                }
            }
            if(j == nums2.length){
                nums1[i] = -1;
            }
        }
        return nums1;
    }
}
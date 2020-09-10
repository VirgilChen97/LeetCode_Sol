class Solution {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0, temp = 0;
        for (int num : nums) {
            temp = (two & num) | (one & ~num);
            two = (~one & ~two & num) | (two & ~num);
            one = temp;
        }
        return two;
    }
}
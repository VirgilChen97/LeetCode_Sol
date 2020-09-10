class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int xs = 0;
        int ys = nums.length/2;
        boolean turn = true;

        for(int i = 0; i < nums.length; i++){
            if(turn){
                res[i] = nums[xs++];
            }else{
                res[i] = nums[ys++];
            }
            turn = !turn;
        }
        return res;
    }
}
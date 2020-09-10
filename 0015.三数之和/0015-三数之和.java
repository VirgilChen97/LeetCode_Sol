class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 3){
            return res;
        }
        for(int i = 0; i < nums.length - 1; i++){
            int l = i + 1, r = nums.length-1;
            if(nums[i] > 0) break;
            if(i!=0 && nums[i] == nums[i-1]) continue;
            while(l<r){
                if(nums[i]+nums[l]+nums[r] > 0){
                    r--;
                }else if(nums[i]+nums[l]+nums[r] < 0){
                    l++;
                }else{
                    List<Integer> oneres = new ArrayList<>();
                    oneres.add(nums[i]);
                    oneres.add(nums[l]);
                    oneres.add(nums[r]);
                    res.add(oneres);
                    while(l < r && nums[l] == nums[l+1]) l++;
                    while(l < r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                }
            }
        }
        return res;
    }
}
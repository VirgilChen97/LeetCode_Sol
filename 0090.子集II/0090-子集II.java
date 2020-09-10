class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        generate(new ArrayList<>(), nums, 0);
        return res;
    }
    public void generate(List<Integer> now, int[] nums,int start){
        res.add(new ArrayList(now));
        for(int i = start; i <nums.length; i++){
                if(i > start && nums[i] == nums[i-1]){
                    continue;
                }
                now.add(nums[i]);
                generate(now, nums ,i+1);
                now.remove(now.size() - 1);
        }
    }
}
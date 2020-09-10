class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        generate(new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }
    public void generate(List<Integer> now, int[] nums, boolean[] usage){
        if(now.size() == nums.length){
            res.add(new ArrayList(now));
            return;
        }
        for(int i = 0; i <nums.length; i++){
            if(!usage[i]){
                now.add(nums[i]);
                usage[i] = true;
                generate(now, nums, usage);
                usage[i] = false;
                now.remove(now.size() - 1);
            }
        }
    }
}
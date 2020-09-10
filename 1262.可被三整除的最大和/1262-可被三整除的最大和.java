class Solution {
    public int maxSumDivThree(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res += nums[i];
        }
        Arrays.sort(nums);
        if(res % 3 == 0){
            return res;
        }else if(res % 3 == 1){
            Integer small1 = null;
            Integer small2 = null;
            Integer big2 = null;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] % 3 == 1){
                    if(small1 == null){
                        small1 = nums[i];
                    }
                }else if(nums[i] % 3 == 2){
                    if(small2 == null){
                        small2 = nums[i];
                    }else if(big2 == null){
                        big2 = nums[i];
                    }
                }
            }
            if(small2 == null || big2 == null){
                return res - small1;
            }else{
                return res - Math.min(small1, small2 + big2);
            }
        }else{
            Integer small1 = null;
            Integer small2 = null;
            Integer big2 = null;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] % 3 == 2){
                    if(small1 == null){
                        small1 = nums[i];
                    }
                }else if(nums[i] % 3 == 1){
                    if(small2 == null){
                        small2 = nums[i];
                    }else if(big2 == null){
                        big2 = nums[i];
                    }
                }
            }
            if(small2 == null || big2 == null){
                return res - small1;
            }else{
                return res - Math.min(small1, small2 + big2);
            }
        }
    }
}
import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        String[] numsString = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            numsString[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsString, new Comparator<String>() {
            @Override
            public int compare(String arg0, String arg1) {
                String order1 = arg0 + arg1;
                String order2 = arg1 + arg0;
                return order2.compareTo(order1);
            }
        });
        if(numsString[0].equals("0")){
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for(String part:numsString){
            res.append(part);
        }
        return res.toString();
    }
}
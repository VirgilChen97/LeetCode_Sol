import java.util.*;
class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>();
        int bigMac = 0;
        int smallWhopper = 0;
        if(tomatoSlices < 2*cheeseSlices){
            return new ArrayList<>();
        }else if(tomatoSlices > 4*cheeseSlices){
            return new ArrayList<>();
        }else if((tomatoSlices & 1) == 1){
            return new ArrayList<>();
        }else{
            smallWhopper = (4*cheeseSlices - tomatoSlices)/2;
            bigMac = cheeseSlices - smallWhopper;
        }
        res.add(bigMac);
        res.add(smallWhopper);
        return res;
    }
}
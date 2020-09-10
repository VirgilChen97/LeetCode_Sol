class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int[] res = new int[2];
        int currentline = 0;
        int total = 0;
        for(char a:S.toCharArray()){
            if(currentline + widths[a-'a'] > 100){
                currentline = widths[a-'a'];
                total+=1;
            }else{
                currentline += widths[a-'a'];
            }
        }
        if(currentline!=0){
            total +=1;
        }
        res[0] = total;
        res[1] = currentline;
        return res;
    }
}
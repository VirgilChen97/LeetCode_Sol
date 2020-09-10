class Solution {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        String[] rome = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int[] number = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        for(int i = number.length - 1; i >= 0; i--){
            while(num > 0){
                num -= number[i];
                if(num > 0){
                    res.append(rome[i]);
                }else if(num == 0){
                    res.append(rome[i]);
                    break;
                }else{
                    num += number[i];
                    break;
                }
            }
        }
        return res.toString();
    }
}
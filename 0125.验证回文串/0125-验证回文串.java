class Solution {
    public boolean isPalindrome(String s) {
        int i,j;
        for(i = 0, j = s.length()-1; i<=j;i++,j--){
            while( !(s.charAt(i)<='z' && s.charAt(i)>='a' || s.charAt(i)<='Z' && s.charAt(i)>='A' || s.charAt(i)>='0' && s.charAt(i)<= '9' ) && i<j ){
                i++;
            }
            while( !(s.charAt(j)<='z' && s.charAt(j)>='a' || s.charAt(j)<='Z' && s.charAt(j)>='A' || s.charAt(j)>='0' && s.charAt(j)<= '9') && i<j ){
                j--;
            }
            if(!String.valueOf(s.charAt(i)).equalsIgnoreCase(String.valueOf(s.charAt(j)))){
                return false;
            }
        }
        return true;
    }
}
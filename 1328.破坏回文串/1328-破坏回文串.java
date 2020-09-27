class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1){
            return "";
        }
        char[] arr = palindrome.toCharArray();
        for(int i=0; i < arr.length; i++){
            if(arr[i] == 'a' || ((arr.length & 1) == 1 && i == arr.length / 2)){
                continue;
            }else{
                arr[i] = 'a';
                return new String(arr);
            }
        }

        arr[arr.length - 1] = 'b';
        return new String(arr);
    }
}
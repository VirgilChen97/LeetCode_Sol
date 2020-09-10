import java.util.*;
class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0){
            return "";
        }
        ArrayList<Integer> space = new ArrayList<>();
        char[] arr = s.toCharArray();
        arr = removeSpace(arr);
        if(arr == null){
            return "";
        }
        reverse(arr,0, arr.length - 1);
        space.add(-1);
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == ' '){
                space.add(i);
            }
        }
        space.add(arr.length);
        for(int i = 1; i < space.size(); i++){
            reverse(arr, space.get(i-1)+1, space.get(i)-1);
        }
        return new String(arr);
    }
    public void reverse(char[] arr, int start, int end){
        int i = start, j = end;
        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public char[] removeSpace(char[] arr){
        char prev = ' ';
        int i = 0, j = 0;
        while(j < arr.length){
            if(arr[j] == ' '){
                if(prev!=' '){
                    arr[i] = arr[j];
                    i++;
                }
            }else{
                arr[i]=arr[j];
                i++;
            }
            prev = arr[j];
            j ++;
        }
        if(i-1<0){
            return null;
        }
        if(arr[i-1] == ' '){
            i--;
        }
        char[] res = new char[i];
        for(int k = 0; k < i;k++){
            res[k] = arr[k];
        }
        return res;
    }
}
import java.util.*;

class Solution {
    String res = "";
    int count;
    public String getHappyString(int n, int k) {
        count = k;
        generate(0, new char[n], n);
        return res;
    }

    public void generate(int pos, char[] arr, int n){
        if(pos == n){
            count --;
            if(count == 0){
                res = new String(arr);
                count --;
                return;
            }
        }else{
            if(count > 0){
                if(pos == 0 || arr[pos-1] != 'a'){
                    arr[pos] = 'a';
                    generate(pos+1, arr, n);
                }
                if(pos == 0 || arr[pos - 1] != 'b'){
                    arr[pos] = 'b';
                    generate(pos+1, arr, n);
                }
                if(pos == 0 || arr[pos - 1] != 'c'){
                    arr[pos] = 'c';
                    generate(pos+1, arr, n);
                }
            }
        }
    }
}
import java.util.*;
class Solution {
    public int fib(int N) {
        ArrayList<Integer> fiba = new ArrayList<>();
        fiba.add(0);
        fiba.add(1);
        if(N == 0 || N == 1){
            return fiba.get(N);
        }
        for (int i = 2; i <= N; i++) {
            fiba.add(fiba.get(i-1)+fiba.get(i-2));
        }
        return fiba.get(N);
    }
}
class Solution {
    public int calPoints(String[] ops) {
        int[] pV = new int[1001];
        int top = -1;
        int res = 0;
        for(String current:ops){
            char c = current.charAt(0);
            int thisRound = 0;
            if(c>='0'&&c<='9'){
                thisRound = c - '0';
            }
            if(c == '+'){
                thisRound = pV[top] + pV[top-1];
            }
            if(c == 'D'){
                thisRound = pV[top] * 2;
            }
            if(c == 'C'){
                res -= pV[top];
                top--;
                continue;
            }
            if(current.length()>1){
                int b = Integer.parseInt(current);
                thisRound = b;
            }
            res += thisRound;
            top++;
            pV[top] = thisRound;
        }
        return res;
    }
}
class Solution {
    ArrayList<Integer> res = new ArrayList<>();
    int n;
    public List<Integer> lexicalOrder(int n) {
        this.n = n;
        for(int i = 1; i < 10; i++){
            if(i <= n){
                generate(i);
            }
        }
        return res;
    }
    public void generate(int now){
        if(now > n){
            return;
        }else{
            res.add(now);
        }
        for(int i = 0; i < 10; i++){
            generate(now * 10 + i);
        }
    }
}
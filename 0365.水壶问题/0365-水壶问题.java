class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x == 0 && y == 0) {
            return z == 0;
        }else{
            return z == 0 || (z % gcd(x,y) == 0 && x + y >= z);
        }
    }
    
    public int gcd(int x,int y){
        if(y == 0) return x;
        int r = x % y;
        return gcd(y,r);
    }
}
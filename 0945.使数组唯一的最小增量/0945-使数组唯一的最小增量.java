class Solution {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int move = 0;
        int lastOccupied = -1;
        Set<Integer> set = new HashSet<>();
        for(int a:A){
            if(a <= lastOccupied){
                move += lastOccupied - a + 1;
                set.add(lastOccupied+1);
                lastOccupied++;
            }else{
                set.add(a);
                lastOccupied = a;
            }
        }
        return move;
    }
}
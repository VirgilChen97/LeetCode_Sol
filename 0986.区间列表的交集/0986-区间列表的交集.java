class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0;
        int j = 0;
        List<int[]> res = new ArrayList<>();
        while(i < A.length && j < B.length){
            int maxL = Math.max(A[i][0], B[j][0]);
            int minR = Math.min(A[i][1], B[j][1]);
            if(maxL <= minR){
                res.add(new int[]{maxL, minR});
            }
            if(A[i][1] > B[j][1]){
                j++;
            }else{
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
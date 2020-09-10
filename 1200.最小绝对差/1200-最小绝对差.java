class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minSub = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - arr[i-1] < minSub){
                minSub = arr[i] - arr[i-1];
                res = new ArrayList<>();
                List<Integer> now = new ArrayList<>();
                now.add(arr[i-1]);
                now.add(arr[i]);
                res.add(now);
            }else if(arr[i] -arr[i-1] == minSub){
                List<Integer> now = new ArrayList<>();
                now.add(arr[i-1]);
                now.add(arr[i]);
                res.add(now);
            }
        }
        return res;
    }
}
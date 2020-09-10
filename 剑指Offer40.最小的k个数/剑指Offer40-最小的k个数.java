class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k <= 0){
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int a:arr){
            if(queue.size() < k){
                queue.add(a);
            }else if (a < queue.peek()){
                queue.poll();
                queue.add(a);
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = queue.poll();
        }
        return res;
    }
}
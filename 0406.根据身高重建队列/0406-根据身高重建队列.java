import java.util.*;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else{
                    return o2[0] - o1[0];
                }
            } 
        });

        LinkedList<int[]> res = new LinkedList<>();
        for(int i = 0; i < people.length; i ++){
            res.add(people[i][1], people[i]);
        }

        return res.toArray(new int[people.length][2]);
    }
}
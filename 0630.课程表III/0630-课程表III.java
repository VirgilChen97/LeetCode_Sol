import java.util.*;

class Solution {
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->b-a);
        Arrays.sort(courses, (c1, c2) -> c1[1] - c2[1]);
        int curr = 0;

        for (int [] course:courses) {
            curr += course[0];
            q.add(course[0]);
            if(curr > course[1]){
                curr -= q.poll();
            }
        }

        return q.size();
    }
}
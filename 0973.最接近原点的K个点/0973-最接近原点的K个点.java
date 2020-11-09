import java.util.Iterator;
import java.util.PriorityQueue;

class Solution {
    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> q = new PriorityQueue<>(K, (p1,p2)->p2.x * p2.x + p2.y*p2.y - p1.x*p1.x - p1.y*p1.y);

        for(int[] point:points){
            if(q.size() < K){
                q.add(new Point(point[0], point[1]));
            }else{
                Point head = q.peek();
                if(point[0] * point[0] + point[1] * point[1] < head.x*head.x + head.y*head.y){
                    q.poll();
                    q.add(new Point(point[0], point[1]));
                }
            }
        }

        int[][] res = new int[K][2];
        Iterator<Point> it = q.iterator();
        int i = 0;
        while(it.hasNext()){
            Point now = it.next();
            res[i][0] = now.x;
            res[i][1] = now.y;
            i++;
        }
        return res;
    }
}
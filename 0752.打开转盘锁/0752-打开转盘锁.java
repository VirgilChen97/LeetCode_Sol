import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        if (target.equals("0000")) {
            return 0;
        }
        if(dead.contains("0000")){
            return -1;
        }
        queue.add("0000");
        visited.add("0000");
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                char[] now = queue.poll().toCharArray();
                for (int i = 0; i < 4; i++) {
                    char temp = now[i];
                    if (now[i] - 1 >= '0') {
                        now[i]--;
                    } else {
                        now[i] = '9';
                    }
                    String prev = new String(now);
                    if (prev.equals(target)) {
                        return step;
                    } else if (!visited.contains(prev) && !dead.contains(prev)) {
                        queue.add(prev);
                        visited.add(prev);
                    }
                    now[i] = temp;
                    if (now[i] + 1 <= '9') {
                        now[i]++;
                    } else {
                        now[i] = '0';
                    }
                    String next = new String(now);
                    if (next.equals(target)) {
                        return step;
                    } else if (!visited.contains(next) && !dead.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                    now[i] = temp;
                }
            }
            step++;
        }
        return -1;
    }
}
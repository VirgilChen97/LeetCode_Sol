import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Map<String, List<String>> g = new HashMap<>();
        for (String word : wordList) {
            g.put(word, new ArrayList<>());
        }

        if(!g.containsKey(endWord)){
            return 0;
        }

        if(!g.containsKey(beginWord)){
            g.put(beginWord, new ArrayList<>());
            wordList.add(beginWord);
        }


        for (String word : wordList) {
            g.put(word, new ArrayList<>());

            outer: for (String now : wordList) {
                boolean hasDiff = false;
                for (int i = 0; i < word.length(); i++) {
                    if (now.charAt(i) != word.charAt(i)) {
                        if (hasDiff)
                            continue outer;
                        else
                            hasDiff = true;
                    }
                }
                if (hasDiff)
                    g.get(word).add(now);
            }
        }

        Set<String> sVisited = new HashSet<>();
        Set<String> eVisited = new HashSet<>();
        Queue<String> sQ = new LinkedList<>();
        Queue<String> eQ = new LinkedList<>();
        sQ.offer(beginWord);
        eQ.offer(endWord);
        sVisited.add(beginWord);
        eVisited.add(endWord);
        int step = 0;

        while (!sQ.isEmpty() && !eQ.isEmpty()) {
            Queue<String> nQ;
            Set<String> nVisited;
            Set<String> oVisited;
            if(sQ.size() < eQ.size()){
                nQ = sQ;
                nVisited = sVisited;
                oVisited = eVisited;
            }else{
                nQ = eQ;
                nVisited = eVisited;
                oVisited = sVisited;
            }
            int size = nQ.size();
            for (int i = 0; i < size; i++) {
                String nNow = nQ.poll();
                for (String neighbor : g.get(nNow)) {
                    if (!nVisited.contains(neighbor)) {
                        if (oVisited.contains(neighbor)) {
                            return step + 2;
                        } else {
                            nVisited.add(neighbor);
                            nQ.add(neighbor);
                        }
                    }
                }
            }
            step++;
        }

        return 0;
    }
}
import java.util.*;

class Solution {
    class zip {
        char a;
        int count;
    }

    public int expressiveWords(String S, String[] words) {
        int count = 0;
        List<zip> s = obtainCount(S);

        for (String word : words) {
            List<zip> w = obtainCount(word);
            if (s.size() != w.size()) {
                continue;
            } else {
                int i = 0;
                for (i = 0; i < w.size(); i++) {
                    if (s.get(i).a != w.get(i).a) {
                        break;
                    } else if (s.get(i).count > w.get(i).count) {
                        if (s.get(i).count < 3) {
                            break;
                        }
                    } else if (s.get(i).count < w.get(i).count) {
                        break;
                    }
                }
                if (i == w.size()) {
                    count++;
                }
            }
        }
        return count;
    }

    public List<zip> obtainCount(String S) {
        int count = 1;
        char[] s = S.toCharArray();
        List<zip> Sc = new ArrayList<>();
        zip zipped = new zip();

        for (int i = 1; i < s.length; i++) {
            if (s[i] != s[i - 1]) {
                zipped = new zip();
                zipped.a = s[i - 1];
                zipped.count = count;
                Sc.add(zipped);
                count = 1;
            } else {
                count++;
            }
        }

        zipped = new zip();
        zipped.a = s[s.length - 1];
        zipped.count = count;
        Sc.add(zipped);

        return Sc;
    }
}
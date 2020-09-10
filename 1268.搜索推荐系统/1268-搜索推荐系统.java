import java.util.*;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new LinkedList<>();
        for (String product : products) {
            list.add(product);
        }
        Collections.sort(list);
        for (int i = 0; i < searchWord.length(); i++) {
            int size = list.size();
            for (int k = 0; k < size; k++) {
                if (list.get(k).length() <= i) {
                    list.remove(k);
                    size--;
                    k--;
                } else {
                    if (list.get(k).charAt(i) != searchWord.charAt(i)) {
                        list.remove(k);
                        size--;
                        k--;
                    }
                }
            }
            if (list.size() <= 3) {
                res.add(new ArrayList<>(list));
            } else {
                List<String> ft = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    ft.add(list.get(j));
                }
                res.add(ft);
            }
        }
        return res;
    }
}
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set set = new HashSet();
        Set res = new HashSet();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String tmp = s.substring(i, i + 10);
            if (set.contains(tmp)) {
                res.add(tmp);
            } else set.add(tmp);
        }
        return new ArrayList<>(res);
    }
}
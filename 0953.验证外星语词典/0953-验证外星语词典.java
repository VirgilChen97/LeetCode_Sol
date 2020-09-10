class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] dict = new int[26];
        for (int i = 0; i < 26; i++) {
            dict[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            int j = 0;
            while (j < word1.length() && j < word2.length() && word1.charAt(j) == word2.charAt(j)) {
                j++;
            }
            if (j >= word2.length() && j < word1.length()) {
                return false;
            } else if (j < word2.length() && j >= word1.length()) {
                continue;
            } else {
                if (dict[word1.charAt(j) - 'a'] > dict[word2.charAt(j) - 'a']) {
                    return false;
                }
            }
        }
        return true;
    }
}
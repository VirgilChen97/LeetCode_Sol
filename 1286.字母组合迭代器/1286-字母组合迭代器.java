class CombinationIterator {
    int[] pos;
    char[] chars;
    int combinationLength;

    public CombinationIterator(String characters, int combinationLength) {
        chars = characters.toCharArray();
        this.combinationLength = combinationLength;
        pos = new int[combinationLength];
        for (int i = 0; i < combinationLength; i++) {
            if (i == combinationLength - 1) {
                pos[i] = i - 1;
            } else {
                pos[i] = i;
            }
        }
    }

    public String next() {
        boolean c = true;
        int now = 0;
        while (c) {
            if (pos[combinationLength - 1 - now] + 1 < chars.length - now) {
                pos[combinationLength - 1 - now]++;
                for (int i = combinationLength - now; i < combinationLength; i++) {
                    pos[i] = pos[combinationLength - 1 - now] + i - (combinationLength - now) + 1;
                }
                c = false;
            } else {
                now++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < combinationLength; i++) {
            sb.append(chars[pos[i]]);
        }
        return sb.toString();
    }

    public boolean hasNext() {
        return pos[0] != chars.length - combinationLength;
    }
}
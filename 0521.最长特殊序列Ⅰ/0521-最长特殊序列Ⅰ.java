class Solution {
    public int findLUSlength(String a, String b) {
        return !(a.equals(b)) && a.length()>b.length()?a.length():(a.equals(b)?-1:b.length());
    }
}
class Solution {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.length() == 0 && B.length() == 0) {
            return true;

        }
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        boolean isOk = false;

        for (int i = 0; i < A.length(); i++) {
            if (a[i] == b[0]) {
                boolean isThisOk = true;
                for (int k = 0; k < A.length(); k++) {
                    if (a[(i + k) % A.length()] != b[k]) {
                        isThisOk = false;
                        break;
                    }
                }
                if(isThisOk){
                    isOk = true;
                    break;
                }
            }
        }
        return isOk;
    }
}
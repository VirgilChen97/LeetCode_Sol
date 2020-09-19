import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        for(int i = 0; i < words.length; i++){
            words[i] = words[i].toLowerCase();
        }
        Arrays.sort(words, (s1, s2)->s1.length()-s2.length());
        words[0] = upperCase(words[0]);
        return String.join(" ", words);
    }

    public static String upperCase(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }
}
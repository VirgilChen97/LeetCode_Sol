import java.util.*;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int prev = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (i == flowerbed.length - 1) {
                if (prev == 0 && flowerbed[flowerbed.length - 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else {
                if (prev == 0 && flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            prev = flowerbed[i];
        }
        if (n > 0) {
            return false;
        } else {
            return true;
        }
    }
}
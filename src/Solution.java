import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1.concat(str2)).equals(str2.concat(str1))) {
            return "";
        }

        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        List<Boolean> result = new ArrayList<>(candies.length);
        for (int i : candies) {
            result.add(i + extraCandies >= max);
        }
        return result;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int len = flowerbed.length;

        for (int i = 0; i < len && count < n; i++) {
            if (flowerbed[i] == 0) {
                // Check left and right neighbors
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                int next = (i == len - 1) ? 0 : flowerbed[i + 1];

                if (prev == 0 && next == 0) {
                    flowerbed[i] = 1; // Place flower
                    count++;
                }
            }
        }
        return count >= n;
    }
}

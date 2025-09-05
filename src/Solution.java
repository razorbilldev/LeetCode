public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.gcdOfStrings("ABABAB", "ABAB"));

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
}

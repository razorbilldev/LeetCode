package LeetCode75.ArrayAndString;

import java.util.*;

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

    public String reverseVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                characters.add(s.charAt(i));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int count = characters.size() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                stringBuilder.append(characters.get(count));
                count--;
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public String reverseVowelsOptimalSolution(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = s.split(" ");
        for (int i = strings.length - 1; i >= 0; i--) {
            if (!strings[i].isEmpty()) {
                stringBuilder.append(strings[i].trim()).append(" ");
            }
        }
        return new String(stringBuilder).trim();
    }

    public String reverseWordsOptimalSolution(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) sb.append(" "); // add space only between words
        }
        return sb.toString();
    }

    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        int temp = 1;
        int count = 0;
        for (int i : nums) {
            if (i != 0) {
                temp *= i;
            } else {
                count++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (count > 1) {
                products[i] = 0;
            } else if (count == 1) {
                products[i] = nums[i] != 0 ? 0 : temp;
            } else {
                products[i] = temp / nums[i];
            }
        }
        return products;
    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }
        return answer;
    }

    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i : nums) {
            if (i <= first) {
                first = i;
            } else if (i <= second) {
                second = i;
            } else {
                return true;
            }
        }
        return false;
    }

    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        char temp = chars[0];
        int counter = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == temp) {
                counter++;
                if (i == chars.length - 1) {
                    sb.append(chars[i]).append(counter);
                }
            } else {
                sb.append(temp).append(counter);
                temp = chars[i];
                counter = 1;
                if (i == chars.length - 1) {
                    sb.append(chars[i]).append(counter);
                }
            }
        }
        return sb.length();
    }

    public int compress2(char[] chars) {
        int read = 0;
        int write = 0;

        while (read < chars.length) {
            char current = chars[read];
            int count = 0;

            while (read < chars.length && chars[read] == current) {
                read++;
                count++;
            }

            chars[write++] = current;

            if (count > 1) {
                for (char ch : String.valueOf(count).toCharArray()) {
                    chars[write++] = ch;
                }
            }
        }
        return write;
    }
}

package LeetCode75.TwoPointers;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxAreaOptimalSolution(height));
    }

    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = 0;
            }
        }
    }

    public void moveZeroesOptimalSolution(int[] nums) {
        int insertPos = 0;
        for (int n : nums) {
            if (n != 0) nums[insertPos++] = n;
        }
        while (insertPos < nums.length) nums[insertPos++] = 0;
    }

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        int position = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(position)) {
                if (++position == s.length()) return true;
            }
        }
        return false;
    }

    // This is a brute-force approuch and time complexity is Big(O)->O(n^2) which is not quite good solution
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int min = Math.min(height[i], height[j]);
                int width = j - i;
                int volume = min * width;
                max = Math.max(max, volume);
            }
        }
        return max;
    }

    // This is 2 pointer approuch which goes through all elements but still guaranties max container volume. Here is the magic behind TwoPointers
    public int maxAreaOptimalSolution(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            int width = right - left;
            int volume = min * width;
            if (volume > max) max = volume;
            if (height[left] > height[right]) right--;
            else left++;
        }
        return max;
    }


}

package LeetCode75.TwoPointers;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {0, 1, 0, 3, 12};
//        solution.moveZeroes(nums);
        System.out.println(solution.isSubsequence("", "abcdf"));
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
}

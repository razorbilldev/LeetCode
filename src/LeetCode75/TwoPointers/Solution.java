package LeetCode75.TwoPointers;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
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
            if (n!=0) nums[insertPos++] = n;
        }
        while (insertPos<nums.length) nums[insertPos++] = 0;
    }
}

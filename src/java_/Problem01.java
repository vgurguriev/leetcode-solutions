package java_;

public class Problem01 {
    /*
    Given an array of integers nums and an integer target,

    return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution,

    and you may not use the same element twice.

    You can return the answer in any order.
    */

    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + nums[i + 1] == target) {
                return new int[]{i, i + 1};
            }
        }
        return new int[0];
    }
}

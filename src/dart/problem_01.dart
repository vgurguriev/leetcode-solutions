// leetcode problem 01 - Two Sum
// https://leetcode.com/problems/two-sum/

class Solution {
  List<int> twoSum(List<int> nums, int target) {
      List<int> result = [];

      for (int i = 0; i < nums.length; i++) {
          for (int j = i + 1; j < nums.length; j++) {
              if (nums[i] + nums[j] == target) {
                  result.add(i);
                  result.add(j);
                  return result;
              }
          }
      }

      return result;
  }
}


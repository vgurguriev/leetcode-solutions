package java_;

    /*
        1027. Longest Arithmetic Subsequence
        https://leetcode.com/problems/longest-arithmetic-subsequence/
     */

public class Problem1027 {
    public static void main(String[] args){
        Problem1027 solution = new Problem1027();
        System.out.println(solution.longestArithSeqLength(new int[]{3,6,9,12}));
        System.out.println(solution.longestArithSeqLength(new int[]{9,4,7,2,10}));
        System.out.println(solution.longestArithSeqLength(new int[]{20,1,15,3,10,5,8}));
    }

    public int longestArithSeqLength(int[] nums) {
        int[][] dp = new int[nums.length][20001];
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                int diff = nums[i] - nums[j] + 10000;
                dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
                max = Math.max(max, dp[i][diff]);
            }
        }
        return max + 1;
    }
}

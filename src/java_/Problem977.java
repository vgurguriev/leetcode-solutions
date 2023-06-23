package java_;
    /*
        977. Squares of a Sorted Array
        https://leetcode.com/problems/squares-of-a-sorted-array/
     */

public class Problem977 {
    public static void main(String[] args) {
        Problem977 solution = new Problem977();
        print(solution.sortedSquares(new int[]{-4, -1, 0, 3, 10}));
        print(solution.sortedSquares(new int[]{-7, -3, 2, 3, 11}));
    }

    private int[] sortedSquares(int[] arr) {
        int[] result = new int[arr.length];
        int i = 0;
        int j = arr.length - 1;
        int k = arr.length - 1;

        while (i <= j) {
            if (Math.abs(arr[i]) > Math.abs(arr[j])) {
                result[k] = arr[i] * arr[i];
                i++;
            } else {
                result[k] = arr[j] * arr[j];
                j--;
            }
            k--;
        }
        return result;
    }

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

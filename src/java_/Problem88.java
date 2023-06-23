package java_;

    /*
        88. Merge Sorted Array
        https://leetcode.com/problems/merge-sorted-array/
     */


public class Problem88 {
    public static void main(String[] args) {
        int[] arr1 = {1};
        int[] arr2 = {};
        merge(arr1, 1, arr2, 0);
        print(arr1);
    }

    private static void merge(int[] arr1, int n, int[] arr2, int m) {
        int i = n - 1;
        int j = m - 1;
        int k = arr1.length - 1;

        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) {
                arr1[k] = arr1[i];
                i--;
                k--;

            } else {
                arr1[k] = arr2[j];
                j--;
                k--;
            }
        }
        while (i >= 0) {
            arr1[k] = arr1[i];
            i--;
            k--;
        }
        while (j >= 0) {
            arr1[k] = arr2[j];
            j--;
            k--;
        }
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

package java_;

    /*
        Given an integer array nums, rotate the array to the right by k steps,
        where k is non-negative.
     */

public class Problem189 {
    public void rotate(int[] arr, int order) {
        order = order % arr.length;
        if (arr == null || order < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        int a = arr.length - order;
        reverse(arr, 0, a - 1);
        reverse(arr, a, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    public static void reverse(int[] arr, int left, int right) {
        if (arr == null || arr.length == 1)
            return;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}

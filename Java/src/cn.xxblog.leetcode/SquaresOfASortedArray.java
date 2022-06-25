package cn.xxblog.leetcode;

/**
 * https://leetcode.cn/problems/squares-of-a-sorted-array/
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        var res = new int[nums.length];
        int index = nums.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                res[index] = nums[left] * nums[left];
                left++;
            } else {
                res[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }
        return res;
    }

    public static void main(String[] args) {
        var arr = new int[]{-7,-3,2,3,11};
        int[] ints = new SquaresOfASortedArray().sortedSquares(arr);
        System.out.println();
    }
}

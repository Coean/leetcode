package cn.xxblog.leetcode;

/**
 * https://leetcode.cn/problems/move-zeroes/
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
                if (i+1 > index) {
                    nums[i] =0;
                }
            }
        }
//        for (int i = index; i < nums.length; i++) {
//            nums[i] = 0;
//        }
    }

    public static void main(String[] args) {
        var arr = new int[]{1, 0, 2, 3, 0, 4};
        new MoveZeroes().moveZeroes(arr);
        System.out.println();
    }

}

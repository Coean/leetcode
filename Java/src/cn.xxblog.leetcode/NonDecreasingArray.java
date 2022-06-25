package cn.xxblog.leetcode;

import javax.sound.midi.Soundbank;

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                if (++count > 1) {
                    return false;
                }
                if (i > 0 && nums[i + 1] < nums[i - 1]) {
                    nums[i + 1] = nums[i];
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        int[] arr = {3, 4, 2, 3};
        System.out.println(nonDecreasingArray.checkPossibility(arr));
        int[] arr1 = {1, 3, 2};
        System.out.println(nonDecreasingArray.checkPossibility(arr1));
        int[] arr2 = {5, 7, 1, 8};
        System.out.println(nonDecreasingArray.checkPossibility(arr2));
        int[] arr3 = {4, 2, 3};
        System.out.println(nonDecreasingArray.checkPossibility(arr3));
        int[] arr4 = {-1, 4, 2, 3};
        System.out.println(nonDecreasingArray.checkPossibility(arr4));
        int[] arr5 = {1, 2, 5, 3,3};
        System.out.println(nonDecreasingArray.checkPossibility(arr5));
        int[] arr6 = {1, 4, 1, 2};
        System.out.println(nonDecreasingArray.checkPossibility(arr6));
    }
}

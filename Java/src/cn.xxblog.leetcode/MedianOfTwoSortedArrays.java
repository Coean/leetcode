package cn.xxblog.leetcode;

/**
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i1 = 0, i2 = 0, tmp = 0, num = 0;
        boolean flag = (nums1.length + nums2.length) % 2 == 0;
        int target = (nums1.length + nums2.length) / 2;
        for (int i = 0; i <= target; i++) {
            if (i1 < nums1.length && (i2 >= nums2.length || nums1[i1] <= nums2[i2])) {
                num = nums1[i1++];
            } else {
                num = nums2[i2++];
            }
            if (flag && i == target - 1) {
                tmp = num;
            }
        }
        if (flag) {
            return (double) (num + tmp) / 2;
        } else {
            return num;
        }

    }

    public static void main(String[] args) {
        int arr1[] = {1, 2};
        int arr2[] = {3, 4};
        double medianSortedArrays = new MedianOfTwoSortedArrays().findMedianSortedArrays( arr2,arr1);

    }
}

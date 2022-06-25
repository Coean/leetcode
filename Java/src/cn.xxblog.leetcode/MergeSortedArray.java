package cn.xxblog.leetcode;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = nums1.length - 1;
        while (last >= 0) {
            if (n <= 0 || (m > 0 && nums1[m - 1] >= nums2[n - 1])) {
                nums1[last] = nums1[m - 1];
                m--;
            } else {
                nums1[last] = nums2[n - 1];
                n--;
            }
            last--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        new MergeSortedArray().merge(nums1, m, nums2, n);
        System.out.println();
    }
}

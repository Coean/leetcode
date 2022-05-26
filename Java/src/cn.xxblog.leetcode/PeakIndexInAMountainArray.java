package cn.xxblog.leetcode;

/**
 * https://leetcode.cn/problems/peak-index-in-a-mountain-array/
 * */
public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
                return mid;
            }
            if (arr[mid - 1] < arr[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}

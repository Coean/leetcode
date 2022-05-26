package cn.xxblog.leetcode;

/**
 * https://leetcode.cn/problems/search-insert-position/
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Math.max(left,right);
    }

    public static void main(String[] args) {
        var arr = new int[]{3,5,7,9};
        new SearchInsertPosition().searchInsert(arr,10);
    }
}

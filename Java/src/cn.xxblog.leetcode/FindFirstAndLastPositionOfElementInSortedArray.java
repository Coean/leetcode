package cn.xxblog.leetcode;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (index == -1) {
            return new int[]{-1, -1};
        } else {
            int temp = index - 1;
            int l = index, r = index;
            while (temp >= 0 && nums[temp] == target) {
                l = temp;
                temp--;
            }
            temp = index + 1;
            while (temp < nums.length && nums[temp] == target) {
                r = temp;
                temp++;
            }
            return new int[]{l, r};
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1};
        new FindFirstAndLastPositionOfElementInSortedArray().searchRange(arr, 1);
    }
}

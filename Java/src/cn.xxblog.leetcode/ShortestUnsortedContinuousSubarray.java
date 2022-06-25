package cn.xxblog.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (stack.size() == 0 || stack.lastElement() <= nums[i]) {
                if (flag) stack.push(nums[i]);
                continue;
            }
            flag = false;
            while (stack.size() > 0 && stack.lastElement() > nums[i]) {
                stack.pop();
            }
        }
        if (stack.size() == nums.length) {
            return 0;
        }
        int left = stack.size();
        stack.clear();
        flag = true;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (stack.size() == 0 || stack.lastElement() >= nums[i]) {
                if (flag) stack.push(nums[i]);
                continue;
            }
            flag = false;
            while (stack.size() > 0 && stack.lastElement() < nums[i]) {
                stack.pop();
            }
        }
        return nums.length - left - stack.size();
    }

    public static void main(String[] args) {
//        var arr = new int[]{1, 3, 5, 6, 5, 4, 7, 3, 8, 9, 10};
        var arr = new int[]{1, 2, 3, 4};
        new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(arr);
    }

}

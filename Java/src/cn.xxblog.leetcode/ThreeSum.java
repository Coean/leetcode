package cn.xxblog.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/3sum/
 */
public class ThreeSum {
    Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int k = nums.length - 1;
            for (int j = i + 1; j < nums.length; j++) {
                while (k > j) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        res.add(List.of(nums[i], nums[j], nums[k]));
                    } else if (sum < 0) {
                        break;
                    }
                    k--;
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{-2, 0, 1, 1, 2};
        int[] arr = new int[]{1,2,-2,-1};

        List<List<Integer>> lists = new ThreeSum().threeSum(arr);
        System.out.println();
    }
}

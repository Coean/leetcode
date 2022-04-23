package cn.xxblog.leetcode;

public class FindClosestNumberToZero {
    public int findClosestNumber(int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (Math.abs(num) < Math.abs(res)) {
                res = num;
            } else if (Math.abs(num) == Math.abs(res) && num > res) {
                res = num;
            }
        }
        return res;
    }

}

package cn.xxblog.leetcode;

/**
 * https://leetcode.cn/problems/valid-perfect-square
 * */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long nn = (long) mid *  mid;
            if (nn == num) {
                return true;
            }
            if (nn < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new ValidPerfectSquare().isPerfectSquare(2147483647);
    }

}

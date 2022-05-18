package cn.xxblog.leetcode;

/**
 * https://leetcode.cn/problems/sqrtx/
 * */
public class Sqrtx {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long nn = (long) mid *  mid;
            if (nn == x) {
                return mid;
            }
            if (nn < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(new Sqrtx().mySqrt(8));
        System.out.println(new Sqrtx().mySqrt(1));
        System.out.println(new Sqrtx().mySqrt(3));
        System.out.println(new Sqrtx().mySqrt(10));
    }

}

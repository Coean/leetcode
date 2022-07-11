package cn.xxblog.leetcode;

/**
 * https://leetcode.cn/problems/first-bad-version/
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 0, right = n;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
                res = mid;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    boolean isBadVersion(int version) {
        return version >= 3;
    }

    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(4));
    }
}

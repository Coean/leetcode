package cn.xxblog.leetcode;

import java.util.HashSet;

/**
 * https://leetcode.cn/problems/longest-consecutive-sequence/
 * */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (Integer num : set) {
            if (!set.contains(num + 1)) {
                int t = 1;
                while (set.contains(--num)) {
                    t++;
                }
                max = Math.max(max, t);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        new LongestConsecutiveSequence().longestConsecutive(arr);
    }

}

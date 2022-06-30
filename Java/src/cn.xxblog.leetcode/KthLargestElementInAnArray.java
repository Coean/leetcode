package cn.xxblog.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        return Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).skip(k - 1).limit(1).findFirst().orElse(0);
    }
}

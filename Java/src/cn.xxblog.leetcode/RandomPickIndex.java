package cn.xxblog.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/random-pick-index/
 * RandomPickIndex
 */
public class RandomPickIndex {

    Map<Integer, LinkedList<Integer>> map = new HashMap<>();

    public RandomPickIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            LinkedList<Integer> orDefault = map.getOrDefault(nums[i], new LinkedList<>());
            orDefault.offer(i);
            map.put(nums[i], orDefault);
        }
    }

    public int pick(int target) {
        LinkedList<Integer> integers = map.get(target);
        Integer res = integers.pop();
        integers.offer(res);
        return res;
    }

}

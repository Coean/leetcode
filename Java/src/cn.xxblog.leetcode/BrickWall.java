package cn.xxblog.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = -1;
        for (List<Integer> arr : wall) {
            int cSum = 0;
            for (int i = 0; i < arr.size() - 1; i++) {
                cSum += arr.get(i);
                int old = map.getOrDefault(cSum,0);
                map.put(cSum, old + 1);
                if (old > max) {
                    max = old+1;
                }

                map.merge(cSum, 1, (o, n) -> o + 1);
                if (map.get(cSum) > max) {
                    max =   map.get(cSum);
                }
            }
        }

        return max == 0 ? wall.size() : wall.size() - max;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 2, 1}, {3, 1, 2}, {1, 3, 2}, {2, 4}, {3, 1, 2}, {1, 3, 1, 1}};
//        int[][] arr = {{1},{1},{1}};
        List<List<Integer>> collect = Arrays.asList(arr).stream().map(bb -> Arrays.stream(bb).boxed().collect(Collectors.toList())).collect(Collectors.toList());
        new BrickWall().leastBricks(collect);
    }
}

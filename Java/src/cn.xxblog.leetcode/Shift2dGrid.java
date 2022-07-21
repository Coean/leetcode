package cn.xxblog.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Shift2dGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            list.addAll(Arrays.stream(grid[i]).boxed().toList());
        }

        for (int i = 0; i < k; i++) {
            list.add(0, list.pollLast());
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            res.add(list.subList(i * grid[i].length, (i + 1) * grid[i].length - 1));
        }
        return res;
    }
}

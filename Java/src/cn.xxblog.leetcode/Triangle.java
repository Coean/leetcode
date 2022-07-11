package cn.xxblog.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, triangle.get(i).get(j) + min);
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {

        int[][] arr = new int[][]{{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        List<List<Integer>> lists = Arrays.stream(arr).map(arr1 -> Arrays.stream(arr1).boxed().collect(Collectors.toList())).collect(Collectors.toList());

        int i = new Triangle().minimumTotal(lists);
        System.out.println(i);
    }
}

package cn.xxblog.leetcode;

/**
 * https://leetcode.cn/problems/max-area-of-island/
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int count = 1;
        count += dfs(grid, i + 1, j);
        count += dfs(grid, i, j + 1);
        count += dfs(grid, i - 1, j);
        count += dfs(grid, i, j - 1);
        return count;
    }

    public static void main(String[] args) {
        var arr = new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 1}};
        int i = new MaxAreaOfIsland().maxAreaOfIsland(arr);
        System.out.println(i);
    }
}

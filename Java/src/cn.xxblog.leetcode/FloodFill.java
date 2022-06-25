package cn.xxblog.leetcode;

/**
 * https://leetcode.cn/problems/flood-fill/
 * */
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int i1) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != i1 || image[sr][sc] == newColor) {
            return;
        }

        image[sr][sc] = newColor;
        dfs(image, sr - 1, sc, newColor, i1);
        dfs(image, sr, sc - 1, newColor, i1);
        dfs(image, sr + 1, sc, newColor, i1);
        dfs(image, sr, sc + 1, newColor, i1);
    }

    public static void main(String[] args) {
//        var arr = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        var arr = new int[][]{{0, 0, 0}, {0, 1, 1}};
        new FloodFill().floodFill(arr, 1, 1, 1);
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[i].length; i1++) {
                System.out.printf("%d\t", arr[i][i1]);
            }
            System.out.println();
        }
    }

}

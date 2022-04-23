package cn.xxblog.leetcode;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/maximal-rectangle/
 *
 * */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int[][] matix1 = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int[] res = getRes(matrix, i);
            matix1[i] = res;
        }

        int max = 0;
        for (int i = 0; i < matix1.length; i++) {
            for (int j = 0; j < matix1[i].length; j++) {
                int cutH = matix1[i][j];
                if (cutH == 0) {
                    continue;
                }
                int width = 1;
                for (int k = j - 1; k >= 0; k--) {
                    if (matix1[i][k] < cutH) {
                        break;
                    }
                    width += 1;
                }
                for (int k = j + 1; k < matix1[i].length; k++) {
                    if (matix1[i][k] < cutH) {
                        break;
                    }
                    width += 1;
                }
                if (width * cutH > max)
                    max = width * cutH;
            }
        }
        return max;
    }

    private int[] getRes(char[][] matrix, int i) {
        int[] res = new int[matrix[0].length];
        HashSet<Integer> indexset = new HashSet<>();
        for (int j = i; j >= 0; j--) {
            for (int k = 0; k < matrix[0].length; k++) {
                if (matrix[j][k] == '1' && !indexset.contains(k)) {
                    res[k] += 1;
                } else {
                    indexset.add(k);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        char[][] matrix = {{'1', '0', '1', '0', '0'},
//                {'1', '0', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '0', '0', '1', '0'}};
        char[][] matrix = {{'1', '0', '0', '0', '1'},
                {'1', '1', '0', '1', '1'},
                {'1', '1', '1', '1', '1'}};
        new MaximalRectangle().maximalRectangle(matrix);

    }
}

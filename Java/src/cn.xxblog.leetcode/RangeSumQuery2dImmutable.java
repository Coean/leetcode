package cn.xxblog.leetcode;

public class RangeSumQuery2dImmutable {
    int[][] matrix;

    public RangeSumQuery2dImmutable(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] m = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
//        {2,1,4,3},{1,1,2,2},{1,2,2,4}

        RangeSumQuery2dImmutable rangeSumQuery2dImmutable = new RangeSumQuery2dImmutable(m);
        int i = rangeSumQuery2dImmutable.sumRegion(2, 1, 4, 3);
        System.out.println(i);
    }

}

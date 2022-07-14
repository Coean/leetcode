package cn.xxblog.leetcode;

public class LCP {

    public int minCostToMoveChips(int[] position) {
        int sc = 0, dc = 0;
        for (int i = 0; i < position.length; i++) {
            dc += position[i] % 2 == 0 ? 0 : 1;
            sc += position[i] % 2 != 0 ? 0 : 1;
        }
        return Math.min(dc, sc);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        new LCP().minCostToMoveChips(arr);
    }
}

package cn.xxblog.leetcode;

public class MaximumDepthOfBinaryTree {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[]{};
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] arr = new int[k+1];
        for (int i = 0; i <= k; i++) {
            arr[i] = i * longer + (k - i) * shorter;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ints = new MaximumDepthOfBinaryTree().divingBoard(1, 2, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

package cn.xxblog.leetcode;

import java.util.concurrent.ArrayBlockingQueue;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int count = 0;
        int[] arr = new int[101];
        for (int height : heights) {
            arr[height]++;
        }
        for (int i = 0, j = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                if (heights[j] != i) {
                    count++;
                }
                j++;
                arr[i]--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        new HeightChecker().heightChecker(arr);
    }
}

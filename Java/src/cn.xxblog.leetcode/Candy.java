package cn.xxblog.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Candy {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i <= ratings.length - 1; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        return IntStream.range(0, ratings.length).map(i -> Math.max(left[i], right[i])).sum();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 87, 87, 87, 2, 1};
        int candy = new Candy().candy(arr);
        System.out.println(candy);
    }
}

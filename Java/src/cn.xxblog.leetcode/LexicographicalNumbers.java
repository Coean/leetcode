package cn.xxblog.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    List<Integer> list = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= 9; i++) {
            dfs(i, n);
        }
        return list;
    }

    private void dfs(int i, int n) {
        if (i > n) {
            return;
        }
        list.add(i);
        for (int j = i * 10; j < i * 10 + 10; j++) {
            dfs(j, n);
        }
    }


    public static void main(String[] args) {
        List<Integer> integers = new LexicographicalNumbers().lexicalOrder(123);
        integers.forEach(System.out::println);

    }
}

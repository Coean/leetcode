package cn.xxblog.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://leetcode-cn.com/problems/richest-customer-wealth/
 * */
public class RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {
        return Stream.of(accounts).map(Arrays::stream).map(IntStream::sum).max(Integer::compareTo).get();
    }

    public static void main(String[] args) {

    }
}


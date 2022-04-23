package cn.xxblog.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MedianFinder {

    private List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        for (int i = 0; i < list.size(); i++) {
            if (num <= list.get(i)) {
                list.add(i, num);
                return;
            }
        }
        list.add(num);
    }

    public double findMedian() {
        int midIndex = list.size() / 2;
        if (list.size() % 2 != 0) {
            return (double) list.get(midIndex);
        }
        return (list.get(midIndex) + list.get(midIndex - 1)) / 2d;
    }

    public static void main(String[] args) {
        System.out.println(5 / 2);
    }
}
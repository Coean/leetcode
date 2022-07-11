package cn.xxblog.leetcode;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());
        for (int[] boxType : boxTypes) {
            treeMap.merge(boxType[1], boxType[0], Integer::sum);
        }
        int sum = 0;
        for (int i = 0; i < truckSize; i++) {
            Map.Entry<Integer, Integer> entry = treeMap.firstEntry();
            if (Objects.isNull(entry)) {
                break;
            }
            sum += entry.getKey();
            if (entry.getValue() - 1 > 0) {
                treeMap.put(entry.getKey(), entry.getValue() - 1);
            } else {
                treeMap.remove(entry.getKey());
            }
        }
        return sum;
    }
}

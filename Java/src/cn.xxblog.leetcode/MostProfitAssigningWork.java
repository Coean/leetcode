package cn.xxblog.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MostProfitAssigningWork {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < profit.length; i++) {
            map.merge(profit[i], difficulty[i], Math::min);
        }

        int total = 0;
        List<Integer> workerList = Arrays.stream(worker).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (Integer integer : workerList) {
            Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> entry = it.next();
                if (integer >= entry.getValue()) {
                    total += entry.getKey();
                    break;
                } else {
                    it.remove();
                }
            }
        }
        return total;
    }


    public static void main(String[] args) {
//        int[] difficulty = {2, 4, 6, 8, 10};
//        int[] profit  = {10,20,30,40,50};
//        int[] worker  = {4,5,6,7};

        int[] difficulty = {85, 47, 57};
        int[] profit = {24, 66, 99};
        int[] worker = {40, 25, 25};
        int i = new MostProfitAssigningWork().maxProfitAssignment(difficulty, profit, worker);
        System.out.println(i);
    }
}

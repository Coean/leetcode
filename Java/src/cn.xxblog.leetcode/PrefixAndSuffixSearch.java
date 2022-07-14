package cn.xxblog.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.TreeSet;
import java.util.function.BiFunction;

public class PrefixAndSuffixSearch {
    HashMap<String, TreeSet<Integer>> prefixMap = new HashMap<>();
    HashMap<String, TreeSet<Integer>> suffixMap = new HashMap<>();

    public PrefixAndSuffixSearch(String[] words) {
        for (int i = 0; i < words.length; i++) {
            final int index = i;
            for (int k = 1; k <= words[i].split("").length; k++) {
                prefixMap.compute(words[i].substring(0, k), initOrPutToMap(index));
            }
            String reverseWord = new StringBuilder(words[i]).reverse().toString();
            for (int k = reverseWord.split("").length - 1; k >= 0; k--) {
                suffixMap.compute(words[i].substring(k), initOrPutToMap(index));
            }
        }
    }
    private BiFunction<String, TreeSet<Integer>, TreeSet<Integer>> initOrPutToMap(int index) {
        return (key, value) -> {
            if (value == null) {
                value = new TreeSet<>(Comparator.reverseOrder());
                value.add(index);
            } else {
                value.add(index);
            }
            return value;
        };
    }

    public int f(String pref, String suff) {
        TreeSet<Integer> prefixSet = prefixMap.get(pref);
        TreeSet<Integer> suffixSet = suffixMap.get(suff);
        if (Objects.isNull(prefixSet) || Objects.isNull(suffixSet)) {
            return -1;
        }
        for (Integer index : prefixSet) {
            if (suffixSet.contains(index)) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] words = {"apple", "appla"};
        PrefixAndSuffixSearch prefixAndSuffixSearch = new PrefixAndSuffixSearch(words);
        System.out.println();
    }
}

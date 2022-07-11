package cn.xxblog.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * minimum-deletions-to-make-character-frequencies-unique
 */
public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public int minDeletions(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (String c : s.split("")) {
            Integer orDefault = map.getOrDefault(c.charAt(0), 0);
            map.put(c.charAt(0), orDefault + 1);
        }
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (Integer i : map.values()) {
            if (!set.contains(i)) {
                set.add(i);
                continue;
            }
            int tmp = i;
            while (tmp-- > 0) {
                if (map.containsValue(tmp) || set.contains(tmp)) {
                    continue;
                }
                count += (i - tmp);
                if (tmp > 0) set.add(tmp);
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumDeletionsToMakeCharacterFrequenciesUnique unique = new MinimumDeletionsToMakeCharacterFrequenciesUnique();
        assert 2 == unique.minDeletions("bbcebab");
        assert 2 == unique.minDeletions("ceabaacb");
        assert 2 == unique.minDeletions("aaabbbcc");
        assert 0 == unique.minDeletions("aab");
        assert 3 == unique.minDeletions("abcabc");
    }
}

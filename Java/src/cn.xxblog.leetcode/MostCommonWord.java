package cn.xxblog.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> black = Stream.of(banned).collect(Collectors.toSet());
        Map<String, Integer> count = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char c : paragraph.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
                continue;
            }
            if (sb.length() == 0) {
                continue;
            }
            String str = sb.toString();
            if (!black.contains(str)) {
                count.merge(str, 1, (o, n) -> o + 1);
            }
            sb = new StringBuilder();
        }
        if (sb.length() != 0) {
            String str = sb.toString();
            if (!black.contains(str)) {
                count.merge(str, 1, (o, n) -> o + 1);
            }
        }

        final Integer max = count.values().stream().max(Integer::compareTo).get();
        return count.entrySet().stream().filter((k) -> k.getValue() == max).findFirst().get().getKey();
    }
}

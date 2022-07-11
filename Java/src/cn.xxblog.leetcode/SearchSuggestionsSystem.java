package cn.xxblog.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        ArrayList<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        for (int i = 1; i <= searchWord.length(); i++) {
            String substring = searchWord.substring(0, i);
            res.add(Arrays.stream(products).filter(s -> s.startsWith(substring)).limit(3).collect(Collectors.toList()));
        }

        return res;
    }


}

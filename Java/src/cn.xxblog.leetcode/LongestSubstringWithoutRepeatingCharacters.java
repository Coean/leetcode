package cn.xxblog.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * LongestSubstringWithoutRepeatingCharacters
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer lastIndex = map.get(s.charAt(i));
            if (lastIndex != null) {
                if (max == 0) {
                    max = i;
                }
                while (s.charAt(start) != s.charAt(i)) {
                    start++;
                }

                max = Math.max(max, i - start);
            }
            map.put(s.charAt(i), i);
        }
        return Math.max(max, s.length() - start);
    }

    public static void main(String[] args) {
        int i = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abba");
        System.out.println(i);
    }

}

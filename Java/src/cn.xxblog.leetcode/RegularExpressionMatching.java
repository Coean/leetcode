package cn.xxblog.leetcode;

/**
 * https://leetcode.cn/problems/regular-expression-matching/
 * */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (s.length() == 0) {
            return true;
        }
        char cp = p.charAt(0);
        char cp2 = p.charAt(1);
        String pa = "";
        if (cp >= 'a' && cp <= 'z') {
            pa += cp;
            if (cp2 == '.' || cp2 == '*') {
                pa += cp2;
            } else {

            }
        } else {
            return false;
        }




        return isMatch(s.substring(1),p.substring(1));
    }
}

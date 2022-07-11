package cn.xxblog.leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (String str : s.split("")) {
            if (")]}".contains(str)) {
                if (stack.size() == 0) {
                    return false;
                }
                String pop = stack.pop();
                if (")".equals(str) && !"(".equals(pop)) {
                    return false;
                }
                if ("}".equals(str) && !"{".equals(pop)) {
                    return false;
                }
                if ("]".equals(str) && !"[".equals(pop)) {
                    return false;
                }
            } else {
                stack.push(str);
            }
        }
        return stack.size() == 0;
    }

}

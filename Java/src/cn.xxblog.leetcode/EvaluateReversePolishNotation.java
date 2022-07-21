package cn.xxblog.leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+-*/".contains(tokens[i])) {
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(calc(tokens[i], v1, v2));
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }

    private int calc(String op, int v1, int v2) {
        switch (op) {
            case "+":
                return v1 + v2;
            case "-":
                return v2 - v1;
            case "*":
                return v1 * v2;
            case "/":
                return v2 / v1;
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] arr = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int i = new EvaluateReversePolishNotation().evalRPN(arr);
        System.out.println(i);
    }
}

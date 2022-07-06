package cn.xxblog.leetcode;

public class FibonacciNumber {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        int fib = fibonacciNumber.fib(10);
        System.out.println(fib);
    }
}

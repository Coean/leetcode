package cn.xxblog.leetcode;

/**
 * https://leetcode.cn/problems/guess-number-higher-or-lower/
 * */
public class GuessNumberHigherOrLower {

    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is lower than the guess number
     *			      1 if num is higher than the guess number
     *               otherwise return 0
     * int guess(int num);
     */
    static int guess(int num){
        return Integer.compare(num, 6);
    }

    public int guessNumber(int n) {
        int left =1;
        int right=n;
        while (left <= right) {
            int mid = (left + right) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = new GuessNumberHigherOrLower().guessNumber(10);
        System.out.println(i);
    }
}

package cn.xxblog.leetcode;

/**
 * https://leetcode.cn/problems/living-people-lcci/
 */
public class LivingPeopleLcci {
    public int maxAliveYear(int[] birth, int[] death) {
        var arr = new int[2001];
        for (int i = 0; i < birth.length; i++) {
            arr[birth[i] - 1900] = arr[birth[i] - 1900] + 1;
        }
        for (int i = 0; i < death.length; i++) {
            arr[death[i] - 1900 + 1] = arr[death[i] - 1900 + 1] - 1;
        }
        int max_index = -1, max = -1, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > max) {
                max = sum;
                max_index = i;
            }
        }
        return 1900 + max_index;
    }

    public static void main(String[] args) {
        var arr1 = new int[]{1927, 1954, 1903, 1928, 1956, 1929, 1929, 1928, 1958, 1902, 1953, 1912, 1923, 1937, 1915, 1942, 1964, 1954, 1924, 1936, 1963, 1950, 1904, 1931, 1951, 1953, 1922, 1970, 1986, 1947, 1911, 1965, 1913, 1920, 1947, 1962, 1903, 1905, 1978, 1974, 1950, 1921, 1929, 1901, 1925, 1929, 1951, 1944, 1945};
        var arr2 = new int[]{1987, 1992, 1967, 1997, 1963, 1970, 1944, 1986, 1997, 1937, 1971, 1982, 1980, 1992, 1995, 1992, 1991, 1964, 1985, 1938, 1975, 1964, 1975, 1961, 1995, 1985, 1946, 1989, 1999, 1994, 1956, 1984, 1999, 1966, 1950, 1993, 1960, 1939, 1990, 1975, 1982, 1921, 1964, 1998, 1969, 1970, 1965, 1973, 1958};

        int i = new LivingPeopleLcci().maxAliveYear(arr1, arr2);
        System.out.println(i);
    }
}

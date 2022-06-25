package cn.xxblog.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class NQueens {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        dfs(0, n, new Stack<>(), new HashSet<>());
        return res;
    }


    void dfs(int row, int n, Stack<Integer> list, Set<String> blockSet) {
        if (row >= n) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if (blockSet.contains(row + "-" + i) || list.contains(i)) {
                continue;
            }
            list.push(i);
            if (row + 1 == n) {
                res.add(getRes(list, n));
            }
            HashSet<String> newSet = new HashSet<>(blockSet);
            newSet.addAll(getBlockSet(row, i, n));
            dfs(row + 1, n, list, newSet);
            list.pop();
        }
    }

    private List<String> getRes(Stack<Integer> stack, int n) {
        List<String> res = new ArrayList<>();
        for (Integer index : stack) {
            StringBuilder builder = new StringBuilder(String.join("", Collections.nCopies(n, ".")));
            builder.setCharAt(index, 'Q');
            res.add(builder.toString());
        }
        return res;
    }

    private Set<String> getBlockSet(int row, int col, int n) {
        HashSet<String> set = new HashSet<>();
        int i = row;
        int j = col;
        while (i < n && j < n) {
            set.add(i + "-" + j);
            i++;
            j++;
        }
        i = row;
        j = col;
        while (i >= 0 && j >= 0) {
            set.add(i + "-" + j);
            i--;
            j--;
        }
        i = row;
        j = col;
        while (i >= 0 || j < n) {
            set.add(i + "-" + j);
            i--;
            j++;
        }
        i = row;
        j = col;
        while (i < n && j >= 0) {
            set.add(i + "-" + j);
            i++;
            j--;
        }
        return set;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new NQueens().solveNQueens(4);
        System.out.println();
    }
}

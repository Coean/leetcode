package cn.xxblog.leetcode;

import java.util.*;

/**
 *  https://leetcode-cn.com/problems/course-schedule/
 *
 * */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            map.merge(prerequisite[0],newArrayList(prerequisite[1]),(v1,v2)-> {
                v1.add(prerequisite[1]);
                return v1;
            });
        }

        for (Map.Entry<Integer, List<Integer>> kv : map.entrySet()) {
            Set<Integer> vvv = new HashSet<>();
            dfs(kv.getKey(), kv.getValue(), vvv, map, new HashSet<>());
            if (vvv.contains(kv.getKey()))
                return false;
        }

        return true;
    }

    private List<Integer> newArrayList(int i) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(i);
        return list;
    }

    private void dfs(Integer subId, List<Integer> needSubList, Set<Integer> vvv,
                     HashMap<Integer, List<Integer>> map, HashSet<Integer> ssSubId) {
        if (needSubList.size() == 0) {
            return;
        }
        for (Integer v : needSubList) {
            if (v.equals(subId)){
                return;
            }
            if (ssSubId.contains(v)) {
                return;
            }
            ssSubId.add(v);
            vvv.add(v);
            dfs(subId, map.getOrDefault(v, new ArrayList<>()), vvv, map, ssSubId);
        }
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2};
        int[] a2 = {2, 3};
        int[] a3 = {3, 2};
        int[][] pa = {a1, a2, a3};
        new CourseSchedule().canFinish(4, pa);
    }
}

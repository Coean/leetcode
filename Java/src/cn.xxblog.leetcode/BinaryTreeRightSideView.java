package cn.xxblog.leetcode;

import cn.xxblog.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> deepQueue = new LinkedList<>();
        nodeQueue.add(root);
        deepQueue.add(1);
        Map<Integer, Integer> map = new TreeMap<>();
        while (nodeQueue.size() > 0) {
            int curDeep = deepQueue.poll();
            TreeNode node = nodeQueue.poll();
            map.put(curDeep, node.val);

            if (node.left != null) {
                nodeQueue.add(node.left);
                deepQueue.add(curDeep + 1);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                deepQueue.add(curDeep + 1);
            }
        }
        return new ArrayList<>(map.values());
    }

}

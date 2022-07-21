package cn.xxblog.leetcode;

import cn.xxblog.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> deepStack = new ArrayDeque<>();
        nodeStack.offer(root);
        deepStack.offer(1);

        List<List<Integer>> list = new ArrayList<>();
        while (nodeStack.size() > 0) {
            TreeNode pop = nodeStack.poll();
            Integer deep = deepStack.poll();
            if (list.size() <    deep) list.add(new ArrayList<>());
            List<Integer> vl = list.get(deep - 1);
            vl.add(pop.val);
            if (pop.left != null) {
                nodeStack.offer(pop.left);
                deepStack.offer(deep + 1);
            }
            if (pop.right != null) {
                nodeStack.offer(pop.right);
                deepStack.offer(deep + 1);
            }
        }
        return list;
    }
}

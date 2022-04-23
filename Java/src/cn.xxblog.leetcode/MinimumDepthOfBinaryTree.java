package cn.xxblog.leetcode;

import cn.xxblog.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumDepthOfBinaryTree {
    class Va {
        TreeNode treeNode;
        int deep;

        public Va(TreeNode treeNode, int deep) {
            this.treeNode = treeNode;
            this.deep = deep;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<Va> deque = new LinkedList<>();
        deque.add(new Va(root, 1));

        while (! deque.isEmpty()) {
            Va va = deque.poll();
            TreeNode node = va.treeNode;
            if (node.left == null && node.right == null) {
                return va.deep;
            }
            if (node.left != null) {
                deque.offer(new Va(node.left, va.deep + 1));
            }
            if (node.right != null) {
                deque.offer(new Va(node.right, va.deep + 1));
            }
        }
        return 0;
    }

}



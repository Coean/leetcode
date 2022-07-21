package cn.xxblog.leetcode;

import cn.xxblog.leetcode.common.TreeNode;

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (!dfs(root.left)) {
            root.left = null;
        }
        if (!dfs(root.right)) {
            root.right = null;
        }
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }

    private boolean dfs(TreeNode node) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null && node.val == 0) {
            return false;
        }
        if (node.left != null && !dfs(node.left)) {
            node.left = null;
        }
        if (node.right != null && !dfs(node.right)) {
            node.right = null;
        }
        if (node.left == null && node.right == null && node.val == 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0, node1, node2);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(1, node3, node4);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(1, node6, node5);

        TreeNode treeNode = new BinaryTreePruning().pruneTree(node7);
        System.out.println();
    }


}

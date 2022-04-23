package cn.xxblog.leetcode;

import cn.xxblog.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        midOrder(root, list);
        return list.stream().sorted().distinct().collect(Collectors.toList()).equals(list);
    }

    private void midOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        midOrder(root.left, list);
        list.add(root.val);
        midOrder(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2, treeNode1, treeNode3);

        new ValidateBinarySearchTree().isValidBST(treeNode2);
    }
}
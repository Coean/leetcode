package cn.xxblog.leetcode;

import cn.xxblog.leetcode.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 * DeleteNodeInABst
 */
public class DeleteNodeInABst {
    TreeNode r = null;

    public TreeNode deleteNode(TreeNode root, int key) {
        r = root;
        dfs(root, null, key);
        return r;
    }

    private void dfs(TreeNode root, TreeNode parentNode, int key) {
        if (root == null) {
            return;
        }
        dfs(root.left, root, key);
        if (root.val == key) {
            TreeNode target = null;
            if (root.left != null) {
                target = root.left;
            } else if (root.right != null) {
                target = root.right;
            }

            if (parentNode == null) {

            }

            if (parentNode.left == root) {
                parentNode.left = target;
            } else if (parentNode.right == root) {
                parentNode.right = target;
            }

        }
        dfs(root.right, root, key);
    }
}

package cn.xxblog.leetcode;

import cn.xxblog.leetcode.common.TreeNode;

/**
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * <p>
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return myBuildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode myBuildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart == pEnd) {
            return null;
        }

        int index = 0;
        for (int i = iStart; i < iEnd; i++) {
            if (inorder[i] == preorder[pStart]) {
                index = i;
                break;
            }
        }
        TreeNode node = new TreeNode();
        node.val = preorder[pStart];
        node.left = myBuildTree(preorder, pStart + 1, pStart + 1 + index - iStart, inorder, iStart, index);
        node.right = myBuildTree(preorder, pStart + 1 + index - iStart, pEnd, inorder, index + 1, iEnd);
        return node;
    }
}

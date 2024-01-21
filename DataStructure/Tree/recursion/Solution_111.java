package DataStructure.Tree.recursion;

import DataStructure.Tree.TreeNode;

public class Solution_111 {
    int height = 0;
    public int minDepth(TreeNode root) {
//        minLeaf(root, 0);
//        return height;

        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left == null) return right + 1; //左右孩子一个不为空，则返回自身深度+孩子深度
        else if (root.right == null) return left + 1;
        else  {
            return Math.min(left, right) + 1; //左孩子和有孩子都为空的情况，则返回自身深度+min(孩子)深度
        }
    }

    private void minLeaf(TreeNode root, int h) {
        if (root == null) return;
        ++h;
        if (root.left==null && root.right==null) {
            height = height == 0 ?  h : Math.min(h, height);
        }
        minLeaf(root.left, h);
        minLeaf(root.right, h);
    }

}

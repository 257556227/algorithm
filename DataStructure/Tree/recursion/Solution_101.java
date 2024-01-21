package DataStructure.Tree.recursion;

import DataStructure.Tree.TreeNode;

public class Solution_101 {
    // 根节点对称，因此看左子树的左孩子 等于 右子树的右孩子
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSameTree(root.left, root.right);
    }
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) return  p == q;
        return q.val == p.val && isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }
}

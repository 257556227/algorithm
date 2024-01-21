package DataStructure.Tree.recursion;

import DataStructure.Tree.TreeNode;

public class Solution_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
//        return pathSum(root, targetSum, root.val);
        // 子树的targetSum用于传递
        boolean l = hasPathSum(root.left, targetSum-root.val);
        boolean r = hasPathSum(root.right, targetSum-root.val);
         // 叶节点才正式 判断 剩余的sum 和 当前值是否相等
        boolean cur = (targetSum == root.val) && (root.left==null) && (root.right==null);
        return l || r || cur;
    }

    private boolean pathSum(TreeNode root, int targetSum, int i) {
        if (root == null) return false;
        // 分三种情况，一是叶子节点，则直接判断
        if (root.left==null && root.right==null) return i == targetSum;
        //另外两种则是 左右孩子得结果
        boolean left = root.left != null ? pathSum(root.left, targetSum, i + root.left.val) : false;
        //有左右孩子，则向下遍历，否则false
        boolean right = root.right != null ? pathSum(root.right, targetSum, i + root.right.val) : false;
        return left || right;
    }
}

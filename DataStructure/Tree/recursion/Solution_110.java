package DataStructure.Tree.recursion;

import DataStructure.Tree.TreeNode;

import java.util.List;

public class Solution_110 {
    public boolean isBalanced(TreeNode root) {
        int h = treeH(root, 0); //等于-1说明不平衡，其余则是平衡
        return h != -1;
    }
    private int treeH(TreeNode root, int h){ //求高度
        if (root == null) return h;
        int left = treeH(root.left, h+1);
        int right = treeH(root.right, h+1);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1; //不平衡则递归返回 -1
        return Math.max(left, right) + 1;
    }
}

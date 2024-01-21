package DataStructure.Tree.recursion;

import DataStructure.Tree.TreeNode;

public class Solution_100 {
    // 两棵树根节点相同(判空分情况)，左右子树也相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) return  p == q;
        return q.val == p.val && isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }
}

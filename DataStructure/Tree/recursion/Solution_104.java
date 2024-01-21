package DataStructure.Tree.recursion;


import DataStructure.Tree.TreeNode;

public class Solution_104 {
    public int maxDepth1(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth1(root.left);
        int right = maxDepth1(root.right);
        return Math.max(left, right) + 1;
    }
    int ans = 0;
    public int maxDepth(TreeNode root) {
        recursion(root, 0);
        return ans;
    }
    public void recursion(TreeNode root, int cnt) {
        if (root == null)
            return;
        ans = Math.max(++cnt, ans);
        recursion(root.left, cnt);
        recursion(root.right, cnt);
    }
}

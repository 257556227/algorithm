package DataStructure.Tree.recursion;

import DataStructure.Tree.TreeNode;

import java.util.Arrays;
import java.util.OptionalInt;

public class Solution_1372 {
    // 每个节点的交错路径等于左右子树交错路径的最大值
    // 而左子树交错路径等于左子树的右子树交错路径+1
    int res = 0;
    public int longestZigZag(TreeNode root) {
        int[] arr = cross(root);
        res = Math.max(res, Math.max(arr[0], arr[1]));
        return res;
    }

    public int[] cross(TreeNode root) {
        if (root == null) return new int[]{-1,-1};
        int[] leftarr = cross(root.left);
        int lmax = Math.max(leftarr[0], leftarr[1]);
        int[] rightarr = cross(root.right);
        int rmax = Math.max(rightarr[0], rightarr[1]);
        res = Math.max(res, Math.max(lmax, rmax));
        return new int[]{leftarr[1] + 1, rightarr[0] + 1};
    }

//    前序遍历
//递：每次遍历时更新长度。这里我们用一个is_left来记录上一此是往左走还是往右走的，
// 如果上一次往左，那么下一次再往左就记录长度为1，否则长度加1；
// 如果上一次是往右那么下一次再往右就记录长度为1，否则长度加1。（同方向长度不变）
    public int longestZigZag0(TreeNode root) {
        dfs(root, true, 0);
        return res;
    }

    public void dfs(TreeNode node, boolean is_left, int len) {
        if (node == null) return;
        res = Math.max(res, len);
        if (is_left){ //上一步往左移
            dfs(node.left, true, 1); //下一次往左走就记为1
            dfs(node.right, false, len + 1);
        }else {//上一步往右移
            dfs(node.left, true, len + 1);
            dfs(node.right, false, 1); // 下一次再往右就记为1
        }
    }
}

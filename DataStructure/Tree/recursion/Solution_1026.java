package DataStructure.Tree.recursion;

import DataStructure.Tree.TreeNode;

public class Solution_1026 {
    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        decend(root.left, root.val, root.val);
        decend(root.right, root.val, root.val);
        return res;
    }
    // max表示祖先中最大，min表祖先中最小，则最大差值一定是，子孙节点与二者差值的绝对值
    private void decend(TreeNode root, int max, int min){
        if (root == null) return;
        res = Math.max(res,
                Math.max( Math.abs(max - root.val), Math.abs(min -root.val))
            );
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        decend( root.left, max, min);
        decend( root.right, max, min);
    }
}

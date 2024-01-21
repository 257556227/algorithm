package DataStructure.Tree.recursion;

import DataStructure.Tree.TreeNode;

public class Solution_1448 {
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return countGood(root.left, root.val) + countGood(root.right, root.val) + 1;
    }

    private int countGood(TreeNode root, int max){
        if (root == null) return 0;
        int cnt = 0;
        if (root.val >= max){
            ++cnt;
            max = root.val;
        }
        return countGood(root.left, max) + countGood(root.right, max) + cnt;
    }
}

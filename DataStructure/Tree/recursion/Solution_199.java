package DataStructure.Tree.recursion;

import DataStructure.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_199 {
    // 1.右视图存在哪里 -》 List
    // 2.遍历的时候 何时 存 -》 右根左第一次遍历到该节点时
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        rightRootLeft(root, rightView, 0);
        return rightView;
    }
    private void rightRootLeft(TreeNode root, List<Integer> rightView, int depth){
        if (root == null) return;
        if (rightView.size() == depth) rightView.add(root.val); //第一次遍历则是右视图
        rightRootLeft(root.right, rightView, depth+1);
        rightRootLeft(root.left, rightView, depth+1);
    }
}

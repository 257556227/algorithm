package DataStructure.Tree.recursion;

import DataStructure.Tree.TreeNode;

public class Solution_129 {
    int height;
    public int sumNumbers(TreeNode root) {
//        height =  treeHeight(root, 0);
        if (root == null) return 0;
        return sumNum(root, 0);
    }

    private int sumNum(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = sum * 10 + root.val;
//        System.out.println("root.val = " + root.val + "; sum="+sum);
        if (root.left == null && root.right == null) return sum;
        int left = 0, right = 0;
        if (root.left!=null){
            left = sumNum(root.left, sum);
        }
        if (root.right!=null){
            right = sumNum(root.right, sum);
        }
        return left + right;
    }

//    private int treeHeight(TreeNode root, int h){
//        if (root == null) return h;
//        return Math.max(treeHeight(root.left, h+1), treeHeight(root.right, h+1));
//    }


}

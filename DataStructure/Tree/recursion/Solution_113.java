package DataStructure.Tree.recursion;

import DataStructure.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        if (root == null) return paths;
        travesel(root, targetSum, paths, new ArrayList<>());
        return paths;
    }

    private void travesel(TreeNode root, int targetSum, List<List<Integer>> paths, List<Integer> path){
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null){
            if (root.val == targetSum){
                paths.add(List.copyOf(path));
            }
        }
        travesel(root.left, targetSum - root.val, paths, path);
        travesel(root.right, targetSum - root.val, paths, path);
        path.remove(path.size() - 1);
    }
}

package DataStructure.Tree.recursion;

import DataStructure.Tree.TreeNode;

import java.util.*;

public class Solution_1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        root = delete(root, set, forest);
        if (root !=null) forest.add(root);
        return forest;
    }
//    写一个 DFS（后序遍历）：
//
//更新左儿子（右儿子）为递归左儿子（右儿子）的返回值。
//如果当前节点被删除，那么就检查左儿子（右儿子）是否被删除，如果没被删除，就加入答案。
//如果当前节点被删除，返回空节点，否则返回当前节点。
//最后，如果根节点没被删除，把根节点加入答案。
    public List<TreeNode> delNodes0(TreeNode root, int[] toDelete) {
        var ans = new ArrayList<TreeNode>();
        var s = new HashSet<Integer>();
        for (int x : toDelete) s.add(x);
        if (dfs(ans, s, root) != null) ans.add(root);
        return ans;
    }

    private TreeNode dfs(List<TreeNode> ans, Set<Integer> s, TreeNode node) {
        if (node == null) return null;
        node.left = dfs(ans, s, node.left); //dfs 后序
        node.right = dfs(ans, s, node.right);
        if (!s.contains(node.val)) return node; // 节点没被删除
        if (node.left != null) ans.add(node.left); //节点被删除后，左右孩子是否存在
        if (node.right != null) ans.add(node.right);
        return null;
    }
//    什么时候需要将一个节点加入到答案中？
//第一种思路：在它的父节点被删除，而自己没有被删除时，将自己加入答案中（我的思路）
//第二种思路：在一个节点自己将被删除，但是子节点不需要被删除时，将子节点加入答案中（灵神的思路）
    private TreeNode delete(TreeNode root, HashSet<Integer> set, List<TreeNode> forest) {
        if (root == null) return null;
        if (set.contains(root.val)){ //只有需要删除的时候，才删除节点从而得到新的树
            if (root.left!=null){ //虽然删除该节点，但其子树还得判断
                root.left = delete(root.left, set, forest);
                if (root.left !=null) forest.add(root.left);
            }
            if (root.right!=null){
                root.right = delete(root.right, set, forest);
                if (root.right !=null) forest.add(root.right);
            }
            return null; //删除该节点
        }else {
            root.left = delete(root.left, set, forest);
            root.right = delete(root.right, set, forest);
            return root;
        }
    }
}

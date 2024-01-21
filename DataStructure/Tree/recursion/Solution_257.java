package DataStructure.Tree.recursion;

import DataStructure.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        countPath(root.left, paths, String.valueOf(root.val));
        countPath(root.right, paths, String.valueOf(root.val));
        if (paths.size() == 0) paths.add(String.valueOf(root.val));
        return paths;
    }

    private void countPath(TreeNode root, List<String> paths, String path){
        if (root == null) return ;
        if (root.left == null && root.right == null){
            paths.add(path + "->" + root.val);
        }
        countPath(root.left, paths, path + "->" + root.val);
        countPath(root.right, paths, path + "->" + root.val);
    }

    public List<String> binaryTreePaths0(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        dfs(root, "", paths);
        return paths;
    }
    public void dfs(TreeNode root, String path, List<String> paths) {
        if (root == null) return;
        StringBuffer pathSb = new StringBuffer(path + root.val); // 先加入val
        if (root.left == null && root.right == null) // 当前节点是叶子节点
            paths.add(pathSb.toString()); // 把路径加入到答案中
        else {
            pathSb.append("->"); //后判断不是叶子节点再加入->
            dfs(root.left, pathSb.toString(), paths); //继续递归遍历
            dfs(root.right, pathSb.toString(), paths);
        }
    }



    /*
            * 核心逻辑：
            * 利用前序遍历，前序遍历可以从上到下顺序指向；
            * 利用List<Integer>存放从上到下的元素，做回溯；
            * 利用List<String>，在找到叶子节点时，通过List<Integer>拼接路径；
            * 难点：
            * 什么时候退出遍历？
            * 之前我们一直是当节点为空时退出；
            * 但现在要在找到叶子节点时做拼接，所以在找到叶子节点之后退出
         */
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            traversal(root, path, result);
            return result;
        }

        public void traversal(TreeNode node, List<Integer> path, List<String> result) {
            path.add(node.val);
            if (node.left == null && node.right == null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < path.size(); i++) {
                    sb.append(path.get(i));
                    if (i != path.size() - 1) {
                        sb.append("->");
                    }
                }
                result.add(sb.toString());
                return;
            }

            if (node.left != null) {
                traversal(node.left, path, result);
                path.remove(path.size() - 1);
            }

            if (node.right != null) {
                traversal(node.right, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}

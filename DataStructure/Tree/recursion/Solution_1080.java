package DataStructure.Tree.recursion;

import DataStructure.Tree.TreeNode;

public class Solution_1080 {
    // 注意： 根-叶路径的根是root 不是自己这个node

    // 对于一个叶子节点，要想删除它，需要满足什么条件？
    // 对于一个叶子节点 leaf，由于根到 leaf 的路径仅有一条，所以如果这条路径的元素和小于 limit，就删除 leaf。

    // 对于一个非叶节点，如果它有一个儿子没被删除，那么它能被删除吗？如果它的儿子都被删除，意味着什么？
    // 对于一个非叶节点 node，如果 node 有一个儿子没被删除，那么 node 就不能被删除。
    // 这可以用反证法证明：假设可以把 node 删除，那么经过 node 的所有路径和都小于 limit，
    // 也就意味着经过 node 的儿子的路径和也小于 limit，说明 node 的儿子需要被删除，矛盾，所以 node 不能被删除。
    //
    //如果 node 的儿子都被删除，说明经过 node 的所有儿子的路径和都小于 limit，
    // 这等价于经过 node 的所有路径和都小于 limi，所以 node 需要被删除。
    //因此，要删除非叶节点 node，当且仅当 node 的所有儿子都被删除。
    //
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        limit -= root.val;
        if (root.left == null && root.right == null) // root 是叶子
            // 如果 limit > 0 说明从根到叶子的路径和小于 limit，删除叶子，否则不删除
            return limit > 0 ? null : root;
        if (root.left != null)
            root.left = sufficientSubset(root.left, limit);
        if (root.right != null)
            root.right = sufficientSubset(root.right, limit);
        // 如果儿子都被删除，就删 root，否则不删 root
        return root.left == null && root.right == null ? null : root;
    }
}

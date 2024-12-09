
//Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// 实现将有序数组转换为高度平衡二叉搜索树
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // 调用辅助方法，传入数组和范围
        return helper(nums, 0, nums.length - 1);
    }

    // 辅助方法，递归构建二叉树
    private TreeNode helper(int[] nums, int left, int right) {
        // 如果范围无效，返回 null
        if (left > right) {
            return null;
        }

        // 计算中间索引，防止溢出
        int mid = left + (right - left) / 2;

        // 创建当前节点，使用中间元素作为节点值
        TreeNode root = new TreeNode(nums[mid]);

        // 递归构建左子树，范围为 [left, mid - 1]
        root.left = helper(nums, left, mid - 1);

        // 递归构建右子树，范围为 [mid + 1, right]
        root.right = helper(nums, mid + 1, right);

        // 返回构建的树节点
        return root;
    }
}
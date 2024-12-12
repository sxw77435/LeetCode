class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> path, List<List<Integer>> result, boolean[] used) {
        if (path.size() == nums.length) { // 当路径长度等于数组长度时，找到一个排列
            result.add(new ArrayList<>(path)); // 将当前排列加入结果集
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // 如果当前数字已被使用，跳过
            used[i] = true; // 标记当前数字为已使用
            path.add(nums[i]); // 添加当前数字到路径
            backtrack(nums, path, result, used); // 递归生成下一层
            path.remove(path.size() - 1); // 撤销选择
            used[i] = false; // 恢复当前数字为未使用
        }
    }
}

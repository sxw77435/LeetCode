class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length]; // 记录数字是否已被使用
        backtrack(list, new ArrayList<>(), nums, visited);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] visited) {
        if (tempList.size() == nums.length) { // 如果路径长度等于数组长度，找到一个排列
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) { // 每次都从头开始遍历
            if (visited[i]) continue; // 如果数字已被使用，则跳过
            visited[i] = true; // 标记当前数字已被使用
            tempList.add(nums[i]); // 添加当前数字到路径
            backtrack(list, tempList, nums, visited); // 递归
            tempList.remove(tempList.size() - 1); // 撤销选择
            visited[i] = false; // 恢复状态
        }
    }
}

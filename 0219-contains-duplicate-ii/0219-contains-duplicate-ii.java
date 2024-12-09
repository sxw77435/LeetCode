//哈希表
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 使用哈希表存储元素及其最新的索引
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                // 检查索引差是否满足条件
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            // 更新当前元素的索引
            map.put(nums[i], i);
        }

        return false; // 如果没有找到，返回 false
    }
}
//哈希表
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       HashMap<Integer, Integer> map = new HashMap<>(); // 用于存储元素及其索引
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true; // 发现满足条件的重复元素
            }
            map.put(nums[i], i); // 更新索引值
        }
        return false; // 遍历结束后无重复
    }
}
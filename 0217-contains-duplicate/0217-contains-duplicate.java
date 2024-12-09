class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // 如果已经存在，返回 true
            }
            seen.add(num); // 如果不存在，加入哈希表
        }

        return false; // 遍历结束，无重复
    }
}

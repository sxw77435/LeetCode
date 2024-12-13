class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: 将所有不在范围 [1, n] 内的数字置为 n + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // Step 2: 标记出现的数字对应的索引位置为负数
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]); // 取绝对值，避免重复标记
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]); // 标记为负数
            }
        }

        // Step 3: 找到第一个未标记为负数的索引
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) { // 如果位置是正数，说明索引对应的数字缺失
                return i + 1;
            }
        }

        // 如果所有数字都在范围内，返回 n + 1
        return n + 1;
    }
}

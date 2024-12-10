class NumArray {
    private int[] prefixSum; // 用于存储前缀和的数组

    // 构造函数：计算前缀和数组
    public NumArray(int[] nums) {
        prefixSum = new int[nums.length]; // 创建前缀和数组
        if (nums.length > 0) {
            prefixSum[0] = nums[0]; // 初始化第一个元素
            for (int i = 1; i < nums.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i]; // 计算每个前缀和
            }
        }
    }

    // 查询范围和的方法
    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefixSum[right]; // 如果从第 0 个元素开始，直接返回前缀和
        }
        return prefixSum[right] - prefixSum[left - 1]; // 通过前缀和计算范围和
    }
}

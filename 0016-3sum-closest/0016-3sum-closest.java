class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 1. 对数组进行排序
        Arrays.sort(nums);
        
        // 2. 初始化最接近的和
        int closestSum = nums[0] + nums[1] + nums[2]; // 初始化为前三个数的和

        // 3. 遍历数组，固定一个数
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1; // 左指针
            int k = nums.length - 1; // 右指针

            // 4. 使用双指针
            while (j < k) {
                int currentSum = nums[i] + nums[j] + nums[k]; // 计算当前三数之和
                
                // 更新最接近的和
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // 调整双指针位置
                if (currentSum > target) {
                    k--; // 当前和大于目标值，右指针左移
                } else if (currentSum < target) {
                    j++; // 当前和小于目标值，左指针右移
                } else {
                    return currentSum; // 完全匹配，直接返回结果
                }
            }
        }

        // 5. 返回最终最接近的和
        return closestSum;
    }
}

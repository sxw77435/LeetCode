class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        // 1. 排序数组
        Arrays.sort(nums);

        // 2. 外层循环，固定第一个数
        for (int i = 0; i < nums.length - 3; i++) {
            // 跳过重复的第一个数
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 3. 第二层循环，固定第二个数
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 跳过重复的第二个数
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // 4. 使用双指针，寻找第三和第四个数
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right]; 
                    if (sum == target) {
                        // 找到一个四元组，加入结果列表
                    res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // 跳过重复的第三个数
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        // 跳过重复的第四个数
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        // 移动指针，继续查找
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++; // 当前和小于目标值，左指针右移
                    } else {
                        right--; // 当前和大于目标值，右指针左移
                    }
                }
            }
        }

        return res; // 返回结果
    }
}

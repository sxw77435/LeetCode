import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: 排序

        for (int i = 0; i < nums.length - 2; i++) {
            // Step 2: 跳过重复的 nums[i]
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i]; // 我们要找两个数，使它们的和为 -nums[i]
            int left = i + 1;
            int right = nums.length - 1;

            // Step 3: 双指针查找
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Step 4: 跳过重复的 left 和 right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}

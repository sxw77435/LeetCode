import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        // 1. 对数组排序
        Arrays.sort(nums);

        // 2. 选择每对中的最小值
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }
}

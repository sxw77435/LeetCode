//利用公式：index = abs(nums[i]) - 1
/*
适用条件
1. 数组的值范围是 [1, n]：

数组中的每个数字都在 [1, n] 范围内，且数组长度为 n。
这是题目明确给定的前提，数字和索引一一对应。

2.数组中可能有重复数字：

即使数组中某些数字重复，这个公式仍然可以准确找到数字对应的索引位置。

*/
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        // 第一遍遍历，标记出现的数字
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // 计算数字对应的索引
            if (nums[index] > 0) { // 如果该位置是正数，标记为负数
                nums[index] = -nums[index];
            }
        }
        
        // 第二遍遍历，找出未标记的数字
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) { // 正数表示数字未出现
                result.add(i + 1); // 缺失数字是索引 + 1
            }
        }
        
        return result;
    }
}

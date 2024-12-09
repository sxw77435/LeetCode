//第一种解法： 数学公式法
//0~n的总和的公式是： n*(n+1)/2
//时间好长
// class Solution {
//     public int missingNumber(int[] nums) {
//         int n = nums.length;
//         int expectedSum = n * (n + 1) / 2; // 理论总和
//         int actualSum = 0;

//         for (int num : nums) {
//             actualSum += num; // 计算实际总和
//         }

//         return expectedSum - actualSum; // 缺失数字
//     }
// }

//第二种方法： 异或法
//最优解法
// class Solution {
//     public int missingNumber(int[] nums) {
//         int n = nums.length;
//         int xor = 0;

//         for (int i = 0; i < n; i++) {
//             xor ^= i;       // 异或索引
//             xor ^= nums[i]; // 异或元素
//         }

//         xor ^= n; // 最后还要与 n 异或
//         return xor;
//     }
//}

//第三种 排序法
import java.util.Arrays;

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums); // 对数组进行排序

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i; // 索引与值不一致，返回索引
            }
        }

        return nums.length; // 如果没有缺失，说明缺失的是 n
    }
}


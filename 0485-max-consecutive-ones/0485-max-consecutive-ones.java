//给出一段二进制数组，之后输出连续1的最大个数
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;      // 最大连续 1 的个数
        int currentCount = 0;  // 当前连续 1 的个数

        for (int num : nums) {
            if (num == 1) {
                currentCount++;         // 当前值是 1，计数器加 1

                //动态比较哪个是最大值，最后返回连续的1的最大值
                maxCount = Math.max(maxCount, currentCount); // 更新最大值

            } else {
                currentCount = 0;       // 遇到 0，重置计数器
            }
        }

        return maxCount; // 返回最大连续 1 的个数
    }
}


/*
遍历过程：
当前数字	currentCount	maxCount	动态更新逻辑
1	        1	            1	        maxCount = Math.max(0, 1) = 1
1	        2	            2	        maxCount = Math.max(1, 2) = 2
0	        0	            2	        遇到 0，currentCount 被重置为 0，保持 maxCount = 2
1	        1	            2	        maxCount = Math.max(2, 1) = 2
1	        2	            2	        maxCount = Math.max(2, 2) = 2
1	        3	            3	        maxCount = Math.max(2, 3) = 3
*/
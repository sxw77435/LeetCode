//第一种解法： 数学公式法
//0~n的总和的公式是： n*(n+1)/2
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2; // 理论总和
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num; // 计算实际总和
        }

        return expectedSum - actualSum; // 缺失数字
    }
}
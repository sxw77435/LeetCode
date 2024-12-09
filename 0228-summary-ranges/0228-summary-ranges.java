
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums.length == 0) {
            return result; // 如果数组为空，直接返回空列表
        }

        int start = nums[0]; // 当前区间的起始数字

        for (int i = 1; i < nums.length; i++) {
            // 检查是否连续
            if (nums[i] != nums[i - 1] + 1) {
                // 如果不连续，保存前一个区间
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start)); // 单个数字
                } else {
                    result.add(start + "->" + nums[i - 1]); // 区间
                }
                start = nums[i]; // 更新起始数字
            }
        }

        // 添加最后一个区间
        if (start == nums[nums.length - 1]) {
            result.add(String.valueOf(start)); // 单个数字
        } else {
            result.add(start + "->" + nums[nums.length - 1]); // 区间
        }

        return result;
    }
}

/*
为什么最后一个区间需要单独处理？
在主循环中，我们是通过检测当前元素和前一个元素是否连续来判断是否结束一个区间：

当 nums[i] 不连续时，会把之前的区间保存到结果中。
然而，最后一个区间不会触发“不连续”的条件，因为遍历到数组末尾时，循环已经退出，还没有机会处理最后的区间。
因此，需要在循环结束后，手动将最后一个区间保存到结果中。

*/
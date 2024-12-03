class Solution {
    public void moveZeroes(int[] nums) {
        //滚雪球
        int snowballSize = 0;
        for(int i = 0; i< nums.length;i++){
            if(nums[i] == 0){
                snowballSize ++;
            }
            //如果当前元素非零并且雪球大小大于 0
            //用临时变量 t 保存当前非零元素 (nums[i])。
            // 将当前位置设置为 0。
            // 将非零元素移动到前面的位置 i - snowballSize
            else if(snowballSize > 0){
                int t = nums[i];
                nums[i] =0;
                nums[i-snowballSize] = t;
            }
        }
    }
}
/*
示例执行过程
假设输入数组为：[0, 1, 0, 3, 12]

初始状态：

nums = [0, 1, 0, 3, 12]
snowballSize = 0
第 1 次循环 (i = 0)：
当前元素 nums[0] = 0。
snowballSize++，雪球大小变为 1。

nums = [0, 1, 0, 3, 12]
snowballSize = 1
第 2 次循环 (i = 1)：
当前元素 nums[1] = 1，非零且 snowballSize > 0。
移动非零元素 1 到位置 1 - 1 = 0，并将当前位置置为 0：

nums = [1, 0, 0, 3, 12]
snowballSize = 1
第 3 次循环 (i = 2)：
当前元素 nums[2] = 0。
snowballSize++，雪球大小变为 2。

nums = [1, 0, 0, 3, 12]
snowballSize = 2
第 4 次循环 (i = 3)：
当前元素 nums[3] = 3，非零且 snowballSize > 0。
移动非零元素 3 到位置 3 - 2 = 1，并将当前位置置为 0：

nums = [1, 3, 0, 0, 12]
snowballSize = 2
第 5 次循环 (i = 4)：
当前元素 nums[4] = 12，非零且 snowballSize > 0。
移动非零元素 12 到位置 4 - 2 = 2，并将当前位置置为 0：

nums = [1, 3, 12, 0, 0]
snowballSize = 2

*/
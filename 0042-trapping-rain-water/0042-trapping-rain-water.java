class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1; // 左右指针
        int leftMax = 0, rightMax = 0; // 左右两侧最大高度
        int water = 0; // 总接雨水量

        while (left < right) {
            if (height[left] < height[right]) {
                // 如果左侧高度小于右侧高度
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // 更新左侧最大高度
                } else {
                    water += leftMax - height[left]; // 计算左侧雨水量
                }
                left++; // 移动左指针
            } else {
                // 如果右侧高度小于或等于左侧高度
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // 更新右侧最大高度
                } else {
                    water += rightMax - height[right]; // 计算右侧雨水量
                }
                right--; // 移动右指针
            }
        }

        return water; // 返回总雨水量
    }
}

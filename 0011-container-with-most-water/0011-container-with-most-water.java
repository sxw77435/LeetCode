class Solution {
    public int maxArea(int[] height) {
        int left = 0; //左边的索引
        int right = height.length -1; //右边的索引
        int maxArea = 0;

        while(left < right){
            int currentArea = Math.min(height[left],height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
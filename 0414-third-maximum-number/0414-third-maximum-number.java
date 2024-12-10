class Solution {
    public int thirdMax(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int lastMax = Integer.MIN_VALUE;
        int count = 0;
        for(int i = n - 1;i >= 0;i--){
            if(nums[i] != lastMax){
                count++;
                lastMax = nums[i];
            }
            if(count == 3){
                return nums[i];
            }
        }      
        return nums[n - 1];
    }
}
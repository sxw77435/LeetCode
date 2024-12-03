class Solution {
    public int removeDuplicates(int[] nums) {
        //j是唯一元素的数量
        int j  = 1;
        for(int i = 1; i < nums.length ; i++){
            if(nums[i] != nums[i - 1]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
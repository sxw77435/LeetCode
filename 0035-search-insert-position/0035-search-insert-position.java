class Solution {
    public int searchInsert(int[] nums, int target) {
        int low  = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = (low + high) >>>1;
            long midVal = nums[mid];

            if(midVal < target){
                low = mid + 1;
            }else if( target < midVal){
                high = mid - 1;
            }else{
                return mid;
            }
        }
        return low;
    }
}
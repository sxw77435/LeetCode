class Solution {
    public int[] searchRange(int[] nums, int target) {
        int x = left(nums,target);
        if(x == -1){
            return new int[]{-1,-1};
        }else{
            return new int[]{x,right(nums,target)};
        }
    }

    public int left(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int candidate = -1;
        while(i <= j){
            int m = (i +j) >>> 1;
            if(target < nums[m]){
                j = m - 1;
            }else if(nums[m] < target){
                i = m + 1;
            }else{
                candidate = m;
                j = m -1;
            }
        }
        return candidate;
    }

    public int right(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int candidate = -1;
        while(i <= j){
            int m = (i +j) >>> 1;
            if(target < nums[m]){
                j = m - 1;
            }else if(nums[m] < target){
                i = m + 1;
            }else{
                candidate = m;
                i = m + 1;
            }
        }
        return candidate;
    }
}
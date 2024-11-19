// class Solution {
//     public int searchInsert(int[] nums, int target) {
//         int low  = 0;
//         int high = nums.length - 1;

//         while(low <= high){
//             int mid = (low + high) >>>1;
//             long midVal = nums[mid];

//             if(midVal < target){
//                 low = mid + 1;
//             }else if( target < midVal){
//                 high = mid - 1;
//             }else{
//                 return mid;
//             }
//         }
//         return low;
//     }
// }

//leftmost
class Solution {
    public int searchInsert(int[] nums, int target) {
        int i  = 0;
        int j = nums.length - 1;

        while(i <=  j ){
            int m = (i + j) >>>1;

            if(target <= nums[m]){
                j = m - 1;
            }else{
                i = m + 1;
            }
        }
        return i;
    }
}
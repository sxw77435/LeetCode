// class Solution {
//     public int search(int[] nums, int target) {
//        int i = 0 , j = nums.length - 1;
//        while(i <= j){
//          int m = (i+j) >>>1;
//          if(target < nums[m]){
//             j = m - 1;
//          }else if(nums[m] < target){
//             i = m + 1;
//          }else{
//             return m;
//          }
//        }
//        return -1;
//     }
// }
// 改动版
// class Solution {
//     public int search(int[] nums, int target) {
//        int i = 0 , j = nums.length;
//        while(i < j){
//          int m = (i+j) >>>1;
//          if(target < nums[m]){
//             j = m ;
//          }else if(nums[m] < target){
//             i = m + 1;
//          }else{
//             return m;
//          }
//        }
//        return -1;
//     }
// }

//平衡版
class Solution {
    public int search(int[] nums, int target) {
       int i = 0 , j = nums.length;
       while(1 < j - i){
         int m = (i+j) >>>1;
         if(target < nums[m]){
            j = m ;
         }else {
            i = m;
         }
       }
       return (nums[i] == target) ? i : -1 ;
    }
}
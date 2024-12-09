//第一种：哈希表
// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         HashSet<Integer> seen = new HashSet<>();

//         for (int num : nums) {
//             if (seen.contains(num)) {
//                 return true; // 如果已经存在，返回 true
//             }
//             seen.add(num); // 如果不存在，加入哈希表
//         }

//         return false; // 遍历结束，无重复
//     }
// }

//第二种：排序法
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums); // 对数组排序

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) { // 检查相邻元素是否相同
                return true;
            }
        }

        return false; // 遍历结束，无重复
    }
}

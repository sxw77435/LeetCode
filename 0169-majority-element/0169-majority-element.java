//第一种解法
// class Solution {
//     public int majorityElement(int[] nums) {
//         Arrays.sort(nums);
//         return nums[nums.length / 2];
//     }
// }
//第二种解法
// class Solution {
//     public int majorityElement(int[] nums) {
//         int n = nums.length;
//         Map<Integer, Integer> map = new HashMap<>();
        
//         for (int i = 0; i < n; i++) {
//             map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//         }
        
//         n = n / 2;
//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//             if (entry.getValue() > n) {
//                 return entry.getKey();
//             }
//         }
        
//         return 0;
//     }
// }

//第三种
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
}
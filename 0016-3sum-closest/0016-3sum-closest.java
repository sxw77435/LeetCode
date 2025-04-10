class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = nums[0]+ nums[1] + nums[2];
        Arrays.sort(nums);

        for(int i = 0; i <nums.length;i++){

            int j = i + 1;
            int k = nums.length - 1;

            while(j < k){
                int Sum = nums[i] + nums[j] + nums[k];

                if(Math.abs(Sum - target) < Math.abs(closestSum - target)){
                    closestSum = Sum;
                }

                if (Sum < target) {
                    j++;
                } else if (Sum > target) {
                    k--;
                } else {
                    // 完全等于目标，直接返回最优解
                    return Sum;
                }
            

            }
        }
        return closestSum;
    }
}
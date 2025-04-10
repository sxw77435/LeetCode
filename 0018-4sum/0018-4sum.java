class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1;
                int d = n - 1;

                while (k < d) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[d]; // 防止整型溢出！

                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        d--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[d]));
                        k++;
                        d--;
                        
                        // 跳过重复的 k 和 d
                        while (k < d && nums[k] == nums[k - 1]) k++;
                        while (k < d && nums[d] == nums[d + 1]) d--;

                        
                    }
                }
            }
        }

        return result;
    }
}

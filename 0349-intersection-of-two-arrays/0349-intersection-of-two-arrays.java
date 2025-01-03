class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        for(int num:nums1){
            set1.add(num);
        }

        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num); // 自动去重
            }
        }
        // 将结果集合转换为数组
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }

        return result;
    }
}
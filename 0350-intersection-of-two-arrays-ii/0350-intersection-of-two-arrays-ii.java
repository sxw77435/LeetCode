class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> result = new ArrayList<>();
        int i = 0; int j = 0;

        // 双指针寻找交集
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]); // 如果相等，加入结果
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++; // 移动较小的指针
            } else {
                j++;
            }
        }

        // 将结果列表转换为数组
        int[] intersection = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            intersection[k] = result.get(k);
        }

        return intersection;
    }
}
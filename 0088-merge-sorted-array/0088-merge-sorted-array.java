//注意，这两个数组本身就是从小到大的数组，之后都储存到nums1中，顺序仍然是从小到大
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int j = 0, i = m; j < n; j++){
            nums1[i] = nums2[j];
            i++;
        }

        Arrays.sort(nums1);
    }
}
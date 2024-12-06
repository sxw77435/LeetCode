//注意，这两个数组本身就是从小到大的数组，之后都储存到nums1中，顺序仍然是从小到大

//第一种方式
// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         //这里的j是nums2的索引值，之后从nums的第m位索引开始添加到nums1中
//         for(int j = 0, i = m; j < n; j++){
//             nums1[i] = nums2[j];
//             i++;
//         }

//         Arrays.sort(nums1);
//     }
// }

//第二种方式
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while(j >= 0){
            if(i >= 0 && nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k --] = nums2[j--];
            }
        }
    }
}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        //i是nums1的指针，j是nums2的指针
        //m1是两个数组同一个指针索引值比较后的较小值，例如nums1[0] = 1 , nums2[0] =2,那么m1 储存 1
        //m2 是储存上一个m1 的值
        int i = 0, j = 0, m1 = 0, m2 = 0;

        //不合并，直接比较两个数组
        for(int count = 0;count <= (n + m) / 2; count++){
            m2 = m1;
            if(i != n && j!= m){
                if(nums1[i] > nums2[j]){
                    m1 = nums2[j++]; //粗存完最小的值后，指针后移
                }else{
                    m1 = nums1[i++];
                }
                //当一个数组都遍历完的情况
            }else if(i < n){
                m1 = nums1[i++];
            }else{
                m1 = nums2[j++];
            }
        }
        //查看两个数组长度是奇数还是偶数
        if((n + m) % 2 == 1){
            return (double) m1;
        }else{
            double ans = (double) m1 + (double) m2;
            return ans / 2;
        }


    }
}
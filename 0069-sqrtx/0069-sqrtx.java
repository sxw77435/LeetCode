//这是一个递增的数组，一个未知的整数x的平方根，会在0和x之间，用二分查找
class Solution {
    public int mySqrt(int x) {
        
        if (x == 0 || x == 1)
            return x;

        
        int start = 1;
        int end = x;
        int mid = -1;

        
        while (start <= end) {
            //不会溢出
            mid = start + (end - start) / 2;

            if ((long) mid * mid > (long) x)
                end = mid - 1;
            else if (mid * mid == x)
               
                return mid;
            else
               
                start = mid + 1;
        }

    
        return Math.round(end);
    }
}
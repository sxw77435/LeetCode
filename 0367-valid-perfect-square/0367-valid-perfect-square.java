class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 1){
            return false;
        }
        //类型统一
        long left = 1, right = num;

        while(left <= right){
            long mid = left + (right - left)/2;
            long square = mid * mid;

            if(square == num){
                return true;
            }else if(square < num){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return false;
    }
}
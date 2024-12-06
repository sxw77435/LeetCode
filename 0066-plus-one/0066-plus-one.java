class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length-1 ; i >= 0;i--){
            digits[i]++;

            if(digits[i] < 10){
                return digits;
            }

            digits[i] = 0;
        }

        //如果数组中的数字都是9的情况
        int[] result = new int[digits.length + 1];
        result[0] = 1; // 首位是 1，其余默认是 0
        return result;
    }
}
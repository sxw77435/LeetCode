class Solution {
    public int lengthOfLastWord(String s) {
        //去掉s的首尾空格，但文字中间的空格不会被去掉
        s = s.trim();
        
        //记录单词的长度
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            }
            //如果遇到了空格，且文字长度大于0的话，则break
            else if (length > 0) {
                break;
            }
        }
        
        return length;
    }
}
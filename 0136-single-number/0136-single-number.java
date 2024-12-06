/*先了解一下异或运算
异或的特点

1. 自反性：
任意数与 0 异或，结果是它本身：a ^ 0 = a
任意数与自己异或，结果是 0：a ^ a = 0

2. 交换性和结合性：
异或满足交换律：a ^ b = b ^ a
异或满足结合律：a ^ (b ^ c) = (a ^ b) ^ c

异或运算可以用在：
找出单独出现的数字：
在一组成对的数字中，利用异或消除重复，最终只剩下那个单独出现的数字。

*/

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0; // 初始化结果为 0
        for (int num : nums) {
            result ^= num; // 数组中的每个数字都会与 result 进行异或。
        }
        return result; // 返回最后的结果（所有成对的数字会被消除）
    }
}
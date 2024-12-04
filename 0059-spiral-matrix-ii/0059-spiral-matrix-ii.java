//给一个正整数n，生成一个n*n的二维数组
//例如，n=3，生成3*3的二维数组，也就是3*3的矩阵
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n]; //初始化一个n*n的矩阵，初始值为0
        int startX = 0, startY = 0;  // 当前起点(x，y)
        int offset = 1;  //用于确定每一圈的边界，每一行或每一列的范围可以从几到几
        int count = 1;  // 矩阵中需要填写的数字
        int loop = 1; // 记录当前的圈数
        int i, j; // j 代表列, i 代表行;

        //为什么是n/2
        /*
            对于偶数矩阵：中间不剩单独的元素，例如n=4，总共有2圈
            对于奇数矩阵：中间会剩下1个元素，要单独处理，例如n=3，中间会剩余一个点

            关于offset：
            完整过程举例：
            以 n=5 为例，分析每一圈填充时 offset 的作用：

            第一圈
            offset = 1： n - offset也就是4
            填充顶部（行 startX = 0，列范围 [0, 4)）
            填充右侧（列 j = 4，行范围 [0, 4)）
            填充底部（行 i = 4，列范围 [4, 0)）
            填充左侧（列 j = 0，行范围 [4, 0)）
            第二圈
            offset = 2：
            填充顶部（行 startX = 1，列范围 [1, 3)）
            填充右侧（列 j = 3，行范围 [1, 3)）
            填充底部（行 i = 3，列范围 [3, 1)）
            填充左侧（列 j = 1，行范围 [3, 1)）
        */
        while (loop <= n / 2) {

            // 顶部
            // 左闭右开，所以判断循环结束时， j 不能等于 n - offset
            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count++;
            }

            // 右列
            // 左闭右开，所以判断循环结束时， i 不能等于 n - offset
            for (i = startX; i < n - offset; i++) {
                nums[i][j] = count++;
            }

            // 底部
            // 左闭右开，所以判断循环结束时， j != startY
            for (; j > startY; j--) {
                nums[i][j] = count++;
            }

            // 左列
            // 左闭右开，所以判断循环结束时， i != startX
            for (; i > startX; i--) {
                nums[i][j] = count++;
            }
            startX++;
            startY++;
            offset++;
            loop++;
        }
        if (n % 2 == 1) { // n 为奇数时，会剩下中间一个点，直接填入剩余数字
            nums[startX][startY] = count;
        }
        return nums;
    }
}


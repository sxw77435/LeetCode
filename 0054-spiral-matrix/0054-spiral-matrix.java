

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result; // 返回空列表
        }

        int top = 0;                      // 上边界
        int right = matrix[0].length - 1; // 右边界
        int bottom = matrix.length - 1;   // 下边界
        int left = 0;                     // 左边界

        while (top <= bottom && left <= right) {
            // 遍历顶部，从左到右
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++; // 上边界下移

            // 遍历右侧，从上到下
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // 右边界左移

            if (top <= bottom) { // 检查是否还有下边界
                // 遍历底部，从右到左
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--; // 下边界上移
            }

            if (left <= right) { // 检查是否还有左边界
                // 遍历左侧，从下到上
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // 左边界右移
            }
        }

        return result;
    }
}

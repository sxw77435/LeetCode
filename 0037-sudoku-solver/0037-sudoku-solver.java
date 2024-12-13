/*
问题描述
编写一个程序，通过填充空格（.）来解决一个数独问题。
数独的解必须满足以下规则：

每行的数字 1-9 不能重复。
每列的数字 1-9 不能重复。
每个 3x3 子格的数字 1-9 不能重复。
*/
class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board); // 开始回溯求解数独
    }

    private boolean backtrack(char[][] board) {
        // 遍历整个数独棋盘
        for (int row = 0; row < 9; row++) { // 遍历每一行
            for (int col = 0; col < 9; col++) { // 遍历每一列
                // 如果当前格子是空格（'.'），尝试填入数字
                if (board[row][col] == '.') {
                    // 尝试填入数字 '1' 到 '9'
                    for (char num = '1'; num <= '9'; num++) {
                        // 检查当前数字是否符合数独规则
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num; // 放置数字
                            // 递归处理下一个空格
                            if (backtrack(board)) {
                                return true; // 如果成功填满整个棋盘，返回 true
                            }
                            board[row][col] = '.'; // 回溯：撤销当前选择
                        }
                    }
                    return false; // 如果没有数字可以填入当前格子，返回 false
                }
            }
        }
        return true; // 如果遍历完所有格子，说明求解成功
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        // 检查当前行是否存在相同数字
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false; // 存在重复数字，返回 false
            }
        }
        // 检查当前列是否存在相同数字
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false; // 存在重复数字，返回 false
            }
        }
        // 检查当前 3x3 子格是否存在相同数字
        int boxRowStart = 3 * (row / 3); // 子格的起始行
        int boxColStart = 3 * (col / 3); // 子格的起始列
        for (int i = 0; i < 3; i++) { // 遍历 3x3 子格的每一行
            for (int j = 0; j < 3; j++) { // 遍历 3x3 子格的每一列
                if (board[boxRowStart + i][boxColStart + j] == num) {
                    return false; // 存在重复数字，返回 false
                }
            }
        }
        return true; // 数字符合规则，返回 true
    }
}



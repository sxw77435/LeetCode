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
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) { // 尝试填入 '1'-'9'
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num; // 放置数字
                            if (backtrack(board)) { // 递归
                                return true;
                            }
                            board[row][col] = '.'; // 回溯
                        }
                    }
                    return false; // 如果没有数字可以放置，返回 false
                }
            }
        }
        return true; // 所有空格已填满
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            // 检查行和列
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
            // 检查 3x3 子格
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == num) {
                return false;
            }
        }
        return true;
    }
}

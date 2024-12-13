import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>(); // 存储所有解
        char[][] board = new char[n][n]; // 棋盘初始化为 n x n 的数组

        // 初始化棋盘，每个位置默认用 '.' 表示空位
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // 开始回溯，从第 0 行开始
        backtrack(solutions, board, 0, n);
        return solutions;
    }

    private void backtrack(List<List<String>> solutions, char[][] board, int row, int n) {
        // 如果已经放置了 n 个皇后，说明找到一个解
        if (row == n) {
            solutions.add(construct(board)); // 将当前棋盘的布局加入结果
            return;
        }

        // 遍历当前行的每一列，尝试放置皇后
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) { // 检查当前位置是否安全
                board[row][col] = 'Q'; // 放置皇后
                backtrack(solutions, board, row + 1, n); // 递归到下一行
                board[row][col] = '.'; // 撤销选择（回溯）
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col, int n) {
        // 检查同列是否有皇后
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 检查左上方对角线是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查右上方对角线是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true; // 如果没有冲突，当前位置安全
    }

    private List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row)); // 将棋盘的一行转换为字符串
        }
        return result;
    }
}

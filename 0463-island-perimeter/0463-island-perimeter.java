//岛屿周长，所有1的格子的周长，而且是在外面的边
class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;         // 网格行数
        int cols = grid[0].length;      // 网格列数
        int perimeter = 0;              // 总周长

        // 遍历网格
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {  // 当前格子是陆地
                    perimeter += 4;    // 初始增加 4 条边
                    
                    // 检查上方
                    if (i > 0 && grid[i - 1][j] == 1) {
                        perimeter -= 2;  // 与上方陆地共享边，减少 2
                    }
                    
                    // 检查左方
                    if (j > 0 && grid[i][j - 1] == 1) {
                        perimeter -= 2;  // 与左方陆地共享边，减少 2
                    }
                }
            }
        }

        return perimeter;  // 返回总周长
    }
}

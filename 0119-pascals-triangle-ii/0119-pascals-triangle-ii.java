class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        // 第 0 行初始化为 [1]
        row.add(1);

        // 从第 1 行开始动态生成，直到第 rowIndex 行
        for (int i = 1; i <= rowIndex; i++) {
            // 从右向左更新当前行
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j - 1) + row.get(j));
            }
            // 在行尾添加 1
            row.add(1);
        }

        return row;
    }
}

// 键盘题解
class Solution {
    public String[] findWords(String[] words) {
        // 定义键盘的三行字母
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        // 存储结果的动态数组
        List<String> result = new ArrayList<>();

        // 遍历每个单词
        for (String word : words) {
            // 将单词转换为小写
            String lowerWord = word.toLowerCase();

            // 检测当前单词是否属于某一行
            if (isInOneRow(lowerWord, row1) || 
                isInOneRow(lowerWord, row2) || 
                isInOneRow(lowerWord, row3)) {
                result.add(word); // 如果满足条件，加入结果列表
            }
        }

        // 将结果转换为数组返回
        return result.toArray(new String[0]);
    }

    // 辅助方法：检查单词是否只由某一行的字母组成
    private boolean isInOneRow(String word, String row) {
        for (char c : word.toCharArray()) {
            if (row.indexOf(c) == -1) { // 如果当前字母不在这一行，返回 false
                return false;
            }
        }
        return true; // 如果所有字母都在这一行，返回 true
    }
}

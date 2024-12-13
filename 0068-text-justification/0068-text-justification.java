//文本左右对齐
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int lineLength = 0;

        for (String word : words) {
            // 如果加入当前单词后超过 maxWidth，开始处理当前行
            if (lineLength + currentLine.size() + word.length() > maxWidth) {
                result.add(formatLine(currentLine, lineLength, maxWidth, false));
                currentLine.clear(); // 清空当前行
                lineLength = 0; // 重置行长度
            }
            // 将单词加入当前行
            currentLine.add(word);
            lineLength += word.length();
        }

        // 处理最后一行，左对齐
        result.add(formatLine(currentLine, lineLength, maxWidth, true));

        return result;
    }

    private String formatLine(List<String> line, int lineLength, int maxWidth, boolean isLastLine) {
        StringBuilder sb = new StringBuilder();
        int numWords = line.size();

        if (isLastLine || numWords == 1) {
            // 最后一行或只有一个单词时，左对齐
            for (String word : line) {
                sb.append(word).append(" ");
            }
            sb.setLength(sb.length() - 1); // 移除多余空格
            while (sb.length() < maxWidth) {
                sb.append(" "); // 填充右侧空格
            }
        } else {
            // 普通行，均匀分配空格
            int totalSpaces = maxWidth - lineLength; // 总空格数
            int spacesBetween = totalSpaces / (numWords - 1); // 每个间隙的空格数
            int extraSpaces = totalSpaces % (numWords - 1); // 多余的空格数

            for (int i = 0; i < line.size() - 1; i++) {
                sb.append(line.get(i));
                for (int j = 0; j < spacesBetween; j++) {
                    sb.append(" "); // 添加均匀空格
                }
                if (i < extraSpaces) {
                    sb.append(" "); // 添加额外空格
                }
            }
            sb.append(line.get(line.size() - 1)); // 添加最后一个单词
        }

        return sb.toString();
    }
}

import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        // 创建结果数组
        String[] result = new String[score.length];

        // 创建一个索引数组，存储每个得分的原始索引
        Integer[] indices = new Integer[score.length];
        for (int i = 0; i < score.length; i++) {
            indices[i] = i;
        }

        // 根据得分对索引数组进行排序（从高到低）
        Arrays.sort(indices, (a, b) -> score[b] - score[a]);

        // 分配名次
        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            if (i == 0) {
                result[index] = "Gold Medal";
            } else if (i == 1) {
                result[index] = "Silver Medal";
            } else if (i == 2) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(i + 1);
            }
        }

        return result;
    }
}

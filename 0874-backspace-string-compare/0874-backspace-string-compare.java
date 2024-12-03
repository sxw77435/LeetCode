class Solution {
    public boolean backspaceCompare(String s, String t) {
        return processString(s).equals(processString(t));
    }

    private String processString(String str) {
        StringBuilder stack = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '#') {
                if (stack.length() > 0) {
                    stack.deleteCharAt(stack.length() - 1); // 模拟退格
                }
            } else {
                stack.append(c); // 将字符添加到结果中
            }
        }
        return stack.toString();
    }
}

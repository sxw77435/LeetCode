class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;

        while (child < g.length && cookie < s.length){
            if(s[cookie] >= g[child]){
                child ++; //孩子指针在饼干被满足时才能移动
            }
            cookie++;
        }
        return child;
    }
}
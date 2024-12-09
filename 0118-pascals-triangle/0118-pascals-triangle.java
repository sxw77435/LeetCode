/*
第 i 行的第 j 个元素（res[i][j]）：
由上一行的第 j-1 个元素（res[i-1][j-1]）和第 j 个元素（res[i-1][j]）之和决定。

由此可得：
res[i][j] = res[i-1][j-1] + res[i-1][j]
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<> ();
        
        for(int i = 0; i < numRows; i++){

            List<Integer> row = new ArrayList<>();

            for(int j = 0; j <= i; j++){

                if(j == 0 || j ==i ){
                    row.add(1);
                }else{
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }
}
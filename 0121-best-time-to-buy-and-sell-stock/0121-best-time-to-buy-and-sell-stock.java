class Solution {
    public int maxProfit(int[] prices) {
        //最低买入价格，初始化为prices[0]
        int buy = prices[0];
        //利润也初始化为0
        int profit = 0;

        //从第二天开始遍历，
        for(int i = 1; i < prices.length; i++){
            //如果当天价格更低，则更新买入最低价格
            if(prices[i] < buy){
                buy = prices[i];
            //如果当天利润更改，则更新利润
            }else if(prices[i] - buy > profit){
                profit = prices[i] - buy;
            }
        }
        return profit;
    }
}
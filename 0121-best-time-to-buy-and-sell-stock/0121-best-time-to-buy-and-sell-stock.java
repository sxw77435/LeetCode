// 第一种
//class Solution {
//     public int maxProfit(int[] prices) {
//         //最低买入价格，初始化为prices[0]
//         int buy = prices[0];
//         //利润也初始化为0
//         int profit = 0;

//         //从第二天开始遍历，
//         for(int i = 1; i < prices.length; i++){
//             //如果当天价格更低，则更新买入最低价格
//             if(prices[i] < buy){
//                 buy = prices[i];
//             //如果当天利润更改，则更新利润
//             }else if(prices[i] - buy > profit){
//                 profit = prices[i] - buy;
//             }
//         }
//         return profit;
//     }
// }

//第二种
class Solution {
    public int maxProfit(int[] prices) {
        // 初始化最低买入价格为无穷大，最大利润为 0
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        // 遍历数组
        for (int price : prices) {
            // 更新最低买入价格
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                // 计算当前利润并更新最大利润
                maxProfit = price - minPrice;
            }
        }

        return maxProfit; // 返回最大利润
    }
}


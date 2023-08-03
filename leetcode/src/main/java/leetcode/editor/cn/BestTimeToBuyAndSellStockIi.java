package leetcode.editor.cn;

//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 3 * 10 ^ 4 
// 0 <= prices[i] <= 10 ^ 4 
// 
// Related Topics 贪心算法 数组 
// 👍 1049 👎 0

public class BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIi().new Solution();
        solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            // 2022.6.7
            // 贪心算法，取 / 向上的区间进行买卖，所有的的向上区间加起来就是最优解，每个区间为数组相邻两个数

            // 利润和
            int sum = 0;
            // 第一个
            int slow = prices[0];
            for (int fast = 1; fast < prices.length; fast++) {
                if (prices[fast] >= slow) {
                    sum += prices[fast] - slow;
                }
                slow = prices[fast]; // 每次更换买点，保证每次遍历时如果当天大于后一天都可以进行卖出
            }
            return sum;


            // [7,1,5,3,6,4]

/////////////////////////1 贪心算法  只要前一天比后一天大就卖，卖了再买，只做加法不做减法///////////////////////
            /*// 利润和
            int sum = 0;
            // 买点
            int slow = prices[0];
            for (int fast = 1; fast < prices.length; fast++) {
                if (prices[fast] >= slow) {
                    sum += prices[fast] - slow;
                }
                slow = prices[fast];
            }
            return sum;*/

            /*// 2021-07-15
            // 画折线图，加速度为正的的线段中起点买、终点卖
            if (prices.length == 1) {
                return 0;
            }
            int sum = 0;
            int buy = -1;// -1 代表未买   [1,2,3,4,5,6]
            for (int i = 0; i < prices.length; i++) {
                // 持有到最后一天，卖
                if (buy != -1 && i == prices.length - 1) {
                    sum += prices[i] - buy;
                    break;
                }
                // 未持有到最后一天
                if (buy == -1 && i == prices.length - 1) {
                    break;
                }

                if (prices[i + 1] > prices[i] && buy == -1) { // 买点
                    buy = prices[i];
                }
                if (prices[i + 1] < prices[i] && buy != -1) { // 卖点
                    sum += prices[i] - buy;//盈利
                    buy = -1;// 卖出
                }
            }
            return sum;*/

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
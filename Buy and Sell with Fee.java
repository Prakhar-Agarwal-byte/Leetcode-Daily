class Solution {
  public int maxProfit(int[] prices, int fee) {
    int hold = -prices[0], cash = 0;
    for (int i = 1; i < prices.length; i++) {
      hold = Math.max(hold, cash - prices[i]);
      cash = Math.max(cash, prices[i] + hold - fee);
    }
    return cash;
  }
}

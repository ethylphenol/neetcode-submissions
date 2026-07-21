class Solution {
    // O(n) time, O(1) space
    public int maxProfit(int[] prices) {
        int lowestLeft = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            lowestLeft = Math.min(lowestLeft, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - lowestLeft);
        }
        return maxProfit;
    }
}

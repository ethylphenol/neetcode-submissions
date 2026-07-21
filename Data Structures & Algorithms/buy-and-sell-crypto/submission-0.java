class Solution {
    // O(n) time, O(n) space
    public int maxProfit(int[] prices) {
        // buy < sell
        int[] lowestLeft = new int[prices.length];
        int[] highestRight = new int[prices.length];
        int maxProfit = 0;

        lowestLeft[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            lowestLeft[i] = Math.min(lowestLeft[i-1], prices[i]);
        }
        highestRight[prices.length-1] = prices[prices.length-1];
        for (int i = prices.length-2; i >= 0; i--) {
            highestRight[i] = Math.max(highestRight[i+1], prices[i]);
        }

        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, highestRight[i] - lowestLeft[i]);
        }
        return maxProfit;
    }
}

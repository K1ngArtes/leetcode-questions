class Solution {
    public int maxProfit(int[] prices) {
        int currentLow = prices[0];
        int profit = 0;
        int i = 0;
        int buy, sell = 0;
        while(i < prices.length-1) {
            // find the local minima
            while(i < prices.length-1 && prices[i] >= prices[i+1]) {
                i++;
            }
            buy = prices[i];
            
            while(i < prices.length-1 && prices[i] < prices[i+1]) {
                i++;
            }
            sell = prices[i];
            
            profit += sell - buy;
        }
        
        return profit;
    }
}
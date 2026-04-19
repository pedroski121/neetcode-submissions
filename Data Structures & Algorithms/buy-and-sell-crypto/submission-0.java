class Solution {
    public int maxProfit(int[] prices) {
             int profit = 0;
        
        for(int i = 0; i < prices.length; i++){
            for(int j = i; j < prices.length; j++){
                int currentProfit = prices[j] - prices[i];
                if(currentProfit <= 0) {
                    continue;
                } else {
                profit = Math.max(currentProfit, profit);

                }
            }
        }
        return profit;
    }
}

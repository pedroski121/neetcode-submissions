class Solution {
    public int maxProfit(int[] prices) {
     int startPointer = 0;
        int endPointer = 1;
        int profit = 0;

        while( endPointer < prices.length) {
            int currentProfit = prices[endPointer] - prices[startPointer];
            if(currentProfit > 0){
                profit = Math.max(currentProfit, profit);
            }

            if(prices[endPointer] < prices[startPointer]){
                startPointer = endPointer;
                
            } 
            endPointer++;
        }
        return profit;
    }
}

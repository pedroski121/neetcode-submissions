class Solution {
    public int maxArea(int[] heights) {
         int area = 0;

       int firstPointer = 0;
       int lastPointer = heights.length - 1;

       while(firstPointer < lastPointer){
        int firstValue = heights[firstPointer];
        int lastValue = heights[lastPointer];
        int value = firstValue > lastValue ? lastValue : firstValue;
       
        int currentArea = value * (lastPointer-firstPointer);
        if(currentArea > area){
            area = currentArea;
        }
        if(firstValue < lastValue){
            firstPointer++;
        } else {
            lastPointer--;
        }
       }

       return area;
    }
}

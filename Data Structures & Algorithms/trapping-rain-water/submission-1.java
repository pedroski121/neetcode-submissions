class Solution {
    public int trap(int[] height) {
   
       int startIndex = 0;
       int endIndex = height.length - 1;

       int sum = 0;

       int startHighest = 0;
       int leftHighest = 0;

       while(startIndex <= endIndex) {

            if(startHighest == leftHighest || startHighest < leftHighest){
                int value = startHighest - height[startIndex];
                if(value > 0){
                    sum += value;
                }
                if(height[startIndex] > startHighest){
                    startHighest = height[startIndex];
                }
                startIndex++;
            } else {
                int value = leftHighest - height[endIndex];
                if(value > 0){
                    sum += value;
                }
                if(height[endIndex] > leftHighest){
                    leftHighest = height[endIndex];
                }
                endIndex--;
            }

       }
       return sum;
    }
}

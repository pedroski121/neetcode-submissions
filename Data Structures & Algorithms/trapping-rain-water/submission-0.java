class Solution {
    public int trap(int[] height) {

        int waterSum = 0;
        for(int i=0; i < height.length; i++){

            int currentValue = height[i];
            
            int leftHandsideHighestValue = 0;
            int rightHandsideHighestValue = 0;
            for(int j = 0; j < i; j++){
                if(leftHandsideHighestValue < height[j]){
                    leftHandsideHighestValue = height[j];
                }
            }

            for(int k = height.length - 1; k > i; k--){
                if(rightHandsideHighestValue < height[k]){
                    rightHandsideHighestValue = height[k];
                }
            }

            int min = Math.min(rightHandsideHighestValue, leftHandsideHighestValue);
            
            int waterCarried = min - currentValue;

            if(waterCarried < 0){
                waterSum += 0;
            } else {
                waterSum += waterCarried;
            }


        }
        return waterSum;
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Iterate through the array 
        // pointer A at zero index
        // pointer B will move through the array 
        // values at pointer A and B are summed up 
        // have a condition that checks if their sum is the target value 
        // After every iteration, if value not found pointer A moves to the next index
         int values[] = new int[2];
             for(int i = 0; i < nums.length; i++){
            int pointerAValue = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                int pointerBValue = nums[j];
                int pointerSum = pointerAValue+pointerBValue;
                if(pointerSum == target){
                    values[0] = i;
                    values[1] = j;
                    
                }
            }
        }
        return values;
    }
}

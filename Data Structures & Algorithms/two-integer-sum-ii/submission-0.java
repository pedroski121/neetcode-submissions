class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int values[] = new int[2];
        
        for(int i = 0; i< numbers.length; i++){
            for(int j = 1; j < numbers.length; j++){
                if(numbers[i] + numbers[j] == target){
                    values[0] = i + 1;
                    values[1] = j + 1;
                    return values;
                }
            }
        }
        return values;
        
    }
}

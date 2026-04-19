class Solution {
    public int[] twoSum(int[] numbers, int target) {

       int firstIndex = 0;

       int lastIndex = numbers.length - 1;

       int indices[] = new int[2];

       while(firstIndex < lastIndex){
        int sum = numbers[firstIndex] + numbers[lastIndex];
            if(sum == target) {
                indices[0] = ++firstIndex;
                indices[1] = ++lastIndex;
                return indices;
            }

            if(sum > target){
                lastIndex--;
            }
            if(sum < target){
                firstIndex++;
            }
       }
       return indices;
        
    }
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {

       HashMap<Integer, Integer> hm = new HashMap<>();

       int values[] = new int[2];

       for(int i = 0; i<numbers.length; i++){
            if(hm.containsKey(target - numbers[i])){
                values[0] = hm.get(target-numbers[i]) + 1;
                values[1] = i + 1;
                return values;
            }

            hm.put(numbers[i], i);

       }

       return values;
        
    }
}

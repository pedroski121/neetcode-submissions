class Solution {
    public int[] topKFrequent(int[] nums, int k) {
     
        /*
        1. Create a hashmap num - freq
        2. Create an list where it index is it frequency and the value at the index
        index is an lsit  of the numbers with that frequency 
        3. iterate through the array from the last element and add it corresponding 
        values to an array to return 
        */
  
    Map<Integer, Integer> mp = new HashMap<>();

    for(int num:nums){
        mp.put(num, mp.getOrDefault(num, 0) + 1);
    }
    List<Integer>[] ls = new ArrayList[nums.length + 1];

    for(int i = 0; i<ls.length; i++){
        ls[i] = new ArrayList<>();
    }
    for(Map.Entry<Integer, Integer> entry: mp.entrySet()){
        ls[entry.getValue()].add(entry.getKey());
    }
    int[] mostFrequentElements = new int[k];

    int index = 0;

    for(int j = ls.length - 1; j > 0 & index < k; j--){
        for(int i: ls[j]){
            mostFrequentElements[index++] = i;
            if(index == k){
                return mostFrequentElements;
            }
        }
    }
    return mostFrequentElements;
   }
}

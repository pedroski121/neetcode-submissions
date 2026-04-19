class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> count = new HashMap<>();

      List<Integer>[] frequency = new List[nums.length + 1];

      for(int i = 0; i<frequency.length; i++){
        frequency[i] = new ArrayList<>();
      }

      for(int num:nums){
        count.put(num, count.getOrDefault(num, 0) + 1);
      }

      for(Map.Entry<Integer, Integer> map: count.entrySet()){
        frequency[map.getValue()].add(map.getKey());
      }

      int[] response = new int[k];

      int index = 0;

      for(int i = frequency.length - 1; i>0 && index <k; i--){
        for(int n:frequency[i]){
            response[index++] = n;
            if(index==k){
                return response;
            }
        }
      }
      return response;
    
      

    }
}

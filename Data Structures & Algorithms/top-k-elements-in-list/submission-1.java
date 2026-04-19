class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap<>();

       for(int num:nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
       }

       List<int[]> ls = new ArrayList();

       for(Map.Entry<Integer, Integer> mp: map.entrySet()){
            ls.add(new int[] {mp.getValue(), mp.getKey()});
       }
       ls.sort((a,b) -> b[0] - a[0]);

       int[] response= new int[k];

       for(int i = 0; i<response.length; i++){
            response[i] = ls.get(i)[1];
       }
       return response;
        
    }
}
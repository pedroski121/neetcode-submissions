class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     Map<String, List<String>> hsmp = new HashMap<>();

        for(String s1:strs){
            int count[] = new int[26];
            for(char s2:s1.toCharArray()){
                count[s2 - 'a']++;
            }
            String key = Arrays.toString(count);
            hsmp.putIfAbsent(key, new ArrayList<String>());
            hsmp.get(key).add(s1);
        }
        return new ArrayList<>(hsmp.values());
    }
}

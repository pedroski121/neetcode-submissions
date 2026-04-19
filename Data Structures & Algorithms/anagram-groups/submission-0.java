class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<String, List<String>> hsmp = new HashMap<>();

       for(int i = 0; i< strs.length; i++){
            char s[] = strs[i].toCharArray();
            Arrays.sort(s);
            String sortedString = new String(s);
            if(hsmp.containsKey(sortedString)){
                hsmp.get(sortedString).add(strs[i]);
            } else {
                List<String> l = new ArrayList();
                l.add(strs[i]);
                hsmp.put(sortedString, l);
            }
       }
       return new ArrayList<>(hsmp.values());
    }
}

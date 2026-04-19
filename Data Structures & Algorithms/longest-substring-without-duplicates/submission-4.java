class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxValue = 0;
       for(int i = 0; i < s.length(); i++){
            Set<Character> hs = new HashSet<>();
            int count = 0;

            for(int j = i; j < s.length(); j++){
                if(hs.contains(s.charAt(j))){
                    break;
                }
                hs.add(s.charAt(j));
                count++;
                maxValue = Math.max(maxValue, count);
            }
       }
       return maxValue;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {

       Set<Character> hs = new HashSet<>();
    
       int maxValue = 0;
     
       int startIndex = 0;
       int endIndex = 0;

       while(endIndex < s.length()) {
            if(hs.contains(s.charAt(endIndex))){
                hs.remove(s.charAt(startIndex));
                startIndex++;
                continue;
            
            }
            hs.add(s.charAt(endIndex));
            maxValue = Math.max(hs.size(), maxValue);

            endIndex++;
       }

       return maxValue;
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
          Map<Character, Integer> characterCount = new HashMap<>();

        int startPointer = 0;
        int endPointer = 0;

        int longestSubstringCount = 0;

        while(endPointer < s.length()) {

            characterCount.put(s.charAt(endPointer), characterCount.getOrDefault(s.charAt(endPointer), 0) + 1);
            int maxValue = 0;
            for(Map.Entry<Character, Integer> entryCount: characterCount.entrySet()){
                maxValue = Math.max(entryCount.getValue(), maxValue);
            }

            int windowSize = endPointer - startPointer + 1;

            int currentSubstringCount = windowSize - maxValue;
            
            if(currentSubstringCount > k){
                characterCount.put(s.charAt(startPointer), characterCount.get(s.charAt(startPointer)) - 1);
                startPointer++;
            } else {
                longestSubstringCount = Math.max(windowSize, currentSubstringCount);
            }
            endPointer++;
        }

        return longestSubstringCount;
    }
}

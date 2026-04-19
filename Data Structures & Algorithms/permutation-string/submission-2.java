class Solution {
    public boolean checkInclusion(String s1, String s2) {

  if(s1.length() > s2.length()){
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for(int i = 0; i < s1.length(); i++){
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;

        for(int i = 0; i < s1Count.length; i++) {
            if(s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        int startPointer = 1;
        int endPointer = s1.length();
        while(endPointer < s2.length()) {

            if(matches == 26) {
                return true;
            }

            int endPointerIndex = s2.charAt(endPointer) - 'a';
            s2Count[endPointerIndex]++;
            if(s2Count[endPointerIndex] == s1Count[endPointerIndex]) {
                matches++;
            } else if(s2Count[endPointerIndex] == s1Count[endPointerIndex] + 1){
                matches--;
            }
            int startPointerIndex = s2.charAt(startPointer-1) - 'a';
            s2Count[startPointerIndex]--;
            if(s2Count[startPointerIndex] == s1Count[startPointerIndex] ){
                matches++;
            } else if(s2Count[startPointerIndex] == s1Count[startPointerIndex] - 1){
                matches--;
            }
            startPointer++;
            endPointer++;
        }
        return matches == 26;
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {

       char[] s1Chars = s1.toCharArray();

       Arrays.sort(s1Chars);

       String s1SortedString = new String(s1Chars);

       int windowLength = s1.length();

       for(int i = 0; i <= s2.length() - windowLength; i++){
            String s2Substring = s2.substring(i, i+windowLength);
            char[] s2Chars = s2Substring.toCharArray();
            Arrays.sort(s2Chars);
            String s2SortedString = new String(s2Chars);
            if(s1SortedString.equals(s2SortedString)){
                return true;
            }
       }
       return false;
    }
}

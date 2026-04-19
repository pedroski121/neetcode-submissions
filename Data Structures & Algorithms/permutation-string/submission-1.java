class Solution {
    public boolean checkInclusion(String s1, String s2) {

      Map<Character, Integer> s1Count = new HashMap<>();

      for(int i = 0; i< s1.length(); i++){
        s1Count.put(s1.charAt(i), s1Count.getOrDefault(s1.charAt(i), 0) + 1);
      }

      for(int j = 0; j <= s2.length() - s1.length(); j++){
        Map<Character, Integer> s2Count = new HashMap<>();
        for(int k = j; k < j + s1.length(); k++){
            s2Count.put(s2.charAt(k), s2Count.getOrDefault(s2.charAt(k), 0) + 1 );
        }
        if(s1Count.equals(s2Count)){
            return true;
        }
      }
      return false;
    }
}

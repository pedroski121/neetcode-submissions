class Solution {
    public boolean isAnagram(String s, String t) {

      if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> hsS= new HashMap<>();
        HashMap<Character, Integer> hsT = new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            hsS.put(s.charAt(i), hsS.getOrDefault(s.charAt(i), 0) + 1);
            hsT.put(t.charAt(i), hsT.getOrDefault(t.charAt(i), 0) + 1);
        }

        return hsS.equals(hsT);
    }
}

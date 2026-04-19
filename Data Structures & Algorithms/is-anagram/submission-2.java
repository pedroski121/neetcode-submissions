class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> hsS= new HashMap<>();
        HashMap<Character, Integer> hsT = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            Integer previousValueS = hsS.get(s.charAt(i));
            if (previousValueS == null) previousValueS = 0;
            previousValueS++;

            hsS.put(s.charAt(i), previousValueS);
        }
        for(int i =0; i < t.length() ; i++){
            Integer previousValueT = hsT.get(t.charAt(i));
            if (previousValueT == null) previousValueT = 0;
            previousValueT++;
            hsT.put(t.charAt(i), previousValueT);

        }

     

        return hsS.equals(hsT);

    }
}

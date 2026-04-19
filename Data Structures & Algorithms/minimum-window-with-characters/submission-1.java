class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length() || t.equals("")){
            return "";
        }
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int j = 0;

        int have = 0, need = tMap.size();

        int currentStringLength = Integer.MAX_VALUE;
        int[] stringIndices = new int[2];

        for(int k = 0; k < s.length(); k++){
            char currentValue = s.charAt(k);
            if(tMap.containsKey(currentValue)){
                sMap.put(currentValue, sMap.getOrDefault(currentValue, 0) + 1);         

                if(tMap.get(currentValue) == sMap.get(currentValue) ){
                    have++;
                }
            }

                while(j <= k && need == have) {
                if(currentStringLength > k+1 - j){
              stringIndices[0] = j;
                stringIndices[1] = k;
                currentStringLength = k + 1 - j;
                }
                    if(tMap.containsKey(s.charAt(j))){
                        sMap.put(s.charAt(j), sMap.get(s.charAt(j)) - 1);
                        if(sMap.get(s.charAt(j)) < tMap.get(s.charAt(j))){
                            have--;
                           
                        }
                    }
                    j++; 
                }

            
        }
        return currentStringLength==Integer.MAX_VALUE ? "" : s.substring(stringIndices[0], stringIndices[1] + 1);
    }
}

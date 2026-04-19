class Solution {
    public String minWindow(String s, String t) {
        // return if t length is greater than s length or if t = ""
        if(t.length() > s.length() || t.equals("")){
            return "";
        }

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        for(int i = 0; i<t.length(); i++){
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int need = tMap.size();
        int have = 0;
        int[] indices = new int[2];
        int minWindow = Integer.MAX_VALUE;

        for(int r = 0; r < s.length(); r++){
            
            char rValue = s.charAt(r);

            if(tMap.containsKey(rValue)){
                sMap.put(rValue, sMap.getOrDefault(rValue, 0) + 1);
                if(sMap.get(rValue) == tMap.get(rValue)){
                    have++;
                }
            }

            while(have == need && l <= r){
                if(minWindow > r + 1 - l){
                    minWindow = r + 1 - l;
                    indices[0] = l;
                    indices[1] = r;
                }
                
                    char lValue = s.charAt(l);
                    if(tMap.containsKey(lValue)){
                        sMap.put(lValue, sMap.get(lValue) - 1);
                        if(sMap.get(lValue) < tMap.get(lValue)){
                            have--;
                        }
                    }

                   
                
                 l++;
            }
        }
        return minWindow == Integer.MAX_VALUE ? "" : s.substring(indices[0], indices[1] + 1);
    }
}

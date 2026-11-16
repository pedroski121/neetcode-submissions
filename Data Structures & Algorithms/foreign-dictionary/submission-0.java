class Solution {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Boolean> visited = new HashMap<>();
        List<Character> res = new ArrayList<>();
    public String foreignDictionary(String[] words) {


        for(String word: words){
            for(Character c: word.toCharArray()){
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String word1 = words[i];
            String word2 = words[i + 1];

            int minLen = Math.min(word1.length(), word2.length());

            if(word1.length() > word2.length() && word1.substring(0, minLen).equals( word2.substring(0, minLen))){
                return "";
            }

            for(int j = 0; j<minLen; j++){
                char w1 = word1.charAt(j);
                char w2 = word2.charAt(j);
                if(w1 != w2){
                    adj.get(w1).add(w2);
                    break;
                }
            }
        }

        for(Map.Entry<Character, Set<Character>> entry: adj.entrySet()){
            if(dfs(entry.getKey())) {
                return "";
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = res.size() -1; i >= 0; i--){
            sb.append(res.get(i));
        }

        return sb.toString();
    }


    public boolean dfs(char c) {
        if(visited.containsKey(c)){
            return visited.get(c);
        }

        visited.put(c, true);

        for(char neighbor: adj.get(c)){

            if(dfs(neighbor)){
                return true;
            }   
        }

        visited.put(c, false);

        res.add(c);
        return false;
    }
}

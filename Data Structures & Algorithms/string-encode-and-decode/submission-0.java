class Solution {

    public String encode(List<String> strs) {
        StringBuilder strBuilder = new StringBuilder();
        for(String s:strs){
            strBuilder.append(s.length()).append('#').append(s);
        }
        return strBuilder.toString();
    }

    public List<String> decode(String str) {
        List<String> ls = new ArrayList<>();
        int startIndex = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '#'){
                Integer wordCount = Integer.parseInt(str.substring(startIndex, i));
                startIndex = i+1;
                i = wordCount + startIndex;
                ls.add(str.substring(startIndex, i));
                startIndex = i;
            }
        }
        return ls;
    }
}

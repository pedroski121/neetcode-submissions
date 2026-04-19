class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s: strs){
            sb.append(s.length()).append('#').append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> ls = new ArrayList<>();
        Integer startIndex = 0;
        while(startIndex < str.length()){
            int endIndex = startIndex;
            while(str.charAt(endIndex) != '#'){
            endIndex++;
            }

            
                int count = Integer.parseInt(str.substring(startIndex, endIndex));
                startIndex = endIndex + 1;
                endIndex = startIndex + count;
                String value = str.substring(startIndex, endIndex);
                ls.add(value);
                startIndex = endIndex;
        }
        return ls;
    }
}

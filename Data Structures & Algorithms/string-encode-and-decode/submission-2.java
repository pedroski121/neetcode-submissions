class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String str: strs){
            sb.append(str.length()).append("#").append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ls = new ArrayList();

        int startIndex = 0;

        while(startIndex < str.length()){

            int endIndex = startIndex;

            while(str.charAt(endIndex) != '#'){
                endIndex++;
            }
            
            int frequency = Integer.parseInt(str.substring(startIndex, endIndex));

            startIndex = endIndex + 1;
            endIndex = startIndex + frequency;

            String word = str.substring(startIndex, endIndex);
            ls.add(word);
            startIndex = endIndex;

        }
        return ls;
    }
}

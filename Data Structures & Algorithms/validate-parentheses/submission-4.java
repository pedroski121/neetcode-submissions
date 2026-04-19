class Solution {
    public boolean isValid(String s) {

        Map<Character, Character> m = new HashMap<>();
        m.put(')', '(');
        m.put('}', '{');
        m.put(']','[');

        Stack<Character> sValues = new Stack();

        char[] sArr = s.toCharArray();

        for(Character j: sArr){
            
            if(m.containsKey(j) && !sValues.empty()){
                char closingBraces = m.get(j);
                if(sValues.peek() == closingBraces){
                    sValues.pop();
                } else {
                    return false;
                }
            }else {
sValues.push(j);
            }
            

        }

        return sValues.empty();
        
    }
}

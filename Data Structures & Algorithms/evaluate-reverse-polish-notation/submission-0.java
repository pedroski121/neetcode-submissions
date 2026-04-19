class Solution {
    public int evalRPN(String[] tokens) {

      Stack<String> s = new Stack<>();

      for(String token:tokens){
        if(token.equals("+")){
            int num1 = Integer.parseInt(s.pop());
            int num2 = Integer.parseInt(s.pop());
            int num3 = num2 + num1;
            s.push(num3 + "");
        }
        else if(token.equals("-")){
      int num1 = Integer.parseInt(s.pop());
            int num2 = Integer.parseInt(s.pop());
            int num3 = num2 - num1;
            s.push(num3 + "");
        }
        else if(token.equals("*")){
      int num1 = Integer.parseInt(s.pop());
            int num2 = Integer.parseInt(s.pop());
            int num3 = num2 * num1;
            s.push(num3 + "");
        }
       else  if(token.equals("/")){
      int num1 = Integer.parseInt(s.pop());
            int num2 = Integer.parseInt(s.pop());
            int num3 = num2 / num1;
            s.push(num3 + "");
        } 
        else {
            s.push(token);
        }
      }

      return Integer.parseInt(s.pop());
    }
}

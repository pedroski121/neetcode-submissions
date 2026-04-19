class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<int[]> stack = new Stack<>();
        int days[] = new int[temperatures.length];

        for(int i = 0; i<temperatures.length; i++){
            if(stack.empty()){
                stack.push(new int[]{temperatures[i],i});
                continue;
            } else {
                
                boolean warmer = stack.peek()[0] < temperatures[i];
                while(!stack.empty() && warmer){
                    int[] values = stack.pop();
                    days[values[1]] = i - values[1];
                    if(!stack.empty()){
                     warmer = stack.peek()[0] < temperatures[i];

                    }

                }
                stack.push(new int[]{temperatures[i],i});
            }
        }
        return days;
    }
}

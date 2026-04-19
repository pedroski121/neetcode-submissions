class Solution {
    public int largestRectangleArea(int[] heights) {

        
        Stack<Integer[]> stack = new Stack<>();

        Integer maxArea = Integer.MIN_VALUE;

        for(int i = 0; i < heights.length; i++){
            if(stack.empty()){
                Integer[] values = {i, heights[i]};
                stack.push(values);
            } else {
                int index = i;
                while(!stack.empty() && stack.peek()[1] > heights[i]){
                index = stack.peek()[0];
                Integer area = stack.peek()[1] * (i - stack.peek()[0]);
                maxArea = Math.max(maxArea, area);
                stack.pop();
                }

                Integer[] values = {index, heights[i]};
                stack.push(values);
            }
        }

        for(Integer[] s: stack){
            Integer area = s[1] * (heights.length - s[0]);
            maxArea = Math.max(maxArea,area);
        }

        return maxArea; 
        
    }
}

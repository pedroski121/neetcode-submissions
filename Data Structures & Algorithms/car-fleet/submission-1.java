class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Integer pair[][] = new Integer[position.length][2];

        for(int i = 0; i < position.length; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a,b)->Integer.compare(a[0], b[0]));

        Stack<Integer[]> stack = new Stack<>();

        for(int j = pair.length - 1; j >= 0; j-- ){
            if(stack.empty()){
                stack.push(pair[j]);
            } else {
                Integer[] topValue = stack.peek();

                Double maxTime1 = (double)(target-topValue[0])/topValue[1];
                Double maxTime2 = (double)(target - pair[j][0])/pair[j][1];

                if(maxTime2 > maxTime1){
                    stack.push(pair[j]);
                }
            }
        }
        return stack.size();
    }
}

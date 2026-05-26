class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone: stones){
            heap.add(stone);
        }

        while(heap.size() > 1){
            int weight1 = heap.poll();
            int weight2 = heap.poll();

            if(weight1 == weight2){
                continue;
            }
            if(weight2 < weight1){
                int newWeight = weight1 - weight2;
                heap.add(newWeight);
            }
        }
        if(heap.size() == 1){
            return heap.peek();
        } 
        return 0;
    }
}

class KthLargest {

    PriorityQueue<Integer> minheap;
    int k;

    public KthLargest(int k, int[] nums) {
        minheap = new PriorityQueue<>();
        this.k = k;
        for(int i = 0; i< nums.length; i++){
            minheap.offer(nums[i]);
        }
    }
    
    public int add(int val) {
        minheap.offer(val);
        while(minheap.size() > k){
            minheap.poll();
        }

        return minheap.peek();

    }
}

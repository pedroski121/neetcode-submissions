class KthLargest {

    private PriorityQueue<Integer> heap;
    private int k;

    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();
        this.k = k;
        for(int num:nums){
            heap.add(num);
        }
    }
    
    public int add(int val) {
        heap.add(val);
        while(heap.size() > k){
            heap.poll();
        }
        return heap.peek();
    }
}

class KthLargest {
    
    
    private List<Integer> l = new ArrayList<>();
    private int k;
    

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int n: nums){
            l.add(n);
        }
    }
    
    public int add(int val) {
        
        l.add(val);
        Collections.sort(l);
        return l.get(l.size() - k);
    }
}

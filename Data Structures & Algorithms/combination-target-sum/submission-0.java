class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        res = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<>();
        backtrack(nums, current, 0, target);
        return res; }

    public void backtrack(int[] nums, List<Integer> current, int i, int target ) {
            if(target == 0) {
                res.add(new ArrayList(current));
                return;
            }
            if(i >= nums.length || target < 0){
                return;
            }
            current.add(nums[i]);
            backtrack(nums, current, i, target - nums[i]);
            current.remove(current.size() - 1);
            backtrack(nums, current, i + 1, target);

        }
    
}

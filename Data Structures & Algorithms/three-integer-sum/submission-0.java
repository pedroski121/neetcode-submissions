class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

       
        Set<List<Integer>> s = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0){
                        List<Integer> li = new ArrayList<>();
                        li.add(nums[i]);
                        li.add(nums[j]);
                        li.add(nums[k]);
                        s.add(li);
                    }
                }
            }
        }
        return new ArrayList(s);
    }
}

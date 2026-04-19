class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> s = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int startIndex = i + 1;
            int lastIndex = nums.length - 1;

            while(startIndex < lastIndex){
                int sum = nums[i] + nums[startIndex] + nums[lastIndex];
                if(sum > 0){
                    lastIndex--;
                } else if(sum < 0) {
                    startIndex++;
                } else {
                    s.add(Arrays.asList(nums[i], nums[startIndex], nums[lastIndex]));
                    startIndex++;
                    lastIndex--;
                
                }

                
            }
        }
        return new ArrayList<>(s);
    }
}

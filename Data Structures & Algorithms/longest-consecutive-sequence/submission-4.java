class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);

        int currentStreak = 1;
        int maxStreak = 1;

        int value = nums[0];

        for(int i = 1; i< nums.length; i++){

            if(value == nums[i]){
                continue;
            }

            if(value + 1 == nums[i]){
                currentStreak++;
                
            } else {
                currentStreak = 1;
            }
            value = nums[i];
            maxStreak = Math.max(currentStreak, maxStreak);

        }
        return maxStreak;
    }
}

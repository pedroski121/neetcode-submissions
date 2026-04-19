class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        Set<Integer> hs = new HashSet<>();

        for(int num: nums){
            hs.add(num);
        }

        
        int maxStreak = 1;

        for(int value: hs) {
            if(!hs.contains(value - 1)){
                int currentStreak = 1;
              
                while(hs.contains(value + currentStreak)){
                    currentStreak++;
                }
                maxStreak = Math.max(currentStreak, maxStreak);
            }

        }
        return maxStreak;

    }
}

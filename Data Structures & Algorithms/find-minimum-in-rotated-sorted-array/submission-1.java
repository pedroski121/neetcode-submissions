class Solution {
    public int findMin(int[] nums) {
       int l = 0; 
        int r = nums.length - 1;
     

        int min = nums[l];

        while(l <= r){
        if(nums[l] < nums[r]){
            min = Math.min(nums[l], min);
            break;
        }
            int mid = (l + r)/2;
            int value = nums[mid];
            min = Math.min(value, min);

            if(value >= nums[l]){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return min;           
    }
}
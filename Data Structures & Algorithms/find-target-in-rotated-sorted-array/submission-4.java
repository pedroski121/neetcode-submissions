class Solution {
    public int search(int[] nums, int target) {
        // Identify if you are in the left/right rotated part 
        // If left 
            // Check if target is greater than the mid value or
            //  if target is less than than the first value 
            //  set left to mid + 1 if that the case 
            // right - 1 otherwise

        // if right 
            // Check if target is less than mid value or 
            // if target is greater than the right most portion
            // - set right to mid - 1
            // - set left to mid + 1
        
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[left] <= nums[mid]) {
                if(target < nums[left] || target > nums[mid]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if(target < nums[mid] || target > nums[right]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

        }

        return -1;
    }
}

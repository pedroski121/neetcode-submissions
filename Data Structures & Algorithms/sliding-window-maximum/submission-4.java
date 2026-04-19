class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      
    int maxElements[] = new int[nums.length - k + 1];

    int l = 0;


    int max = Integer.MIN_VALUE;
    for(int r = k; r<=nums.length; r++) {

      for(int i = l; i < r; i++){
        max = Math.max(max, nums[i]);
      }
      maxElements[l] = max;
      max = Integer.MIN_VALUE;
      l++;
    }
  return maxElements;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      
      int[] maxElements = new int[nums.length - k + 1];

      int r = k;

      int l = 0;

      int max = Integer.MIN_VALUE;

      int index = 0;

      while(r <= nums.length){

            int ll = l;
            while(ll < r){

                max = Math.max(max, nums[ll]);

                ll++;
            }
        maxElements[index] = max;
        index++;
        max = Integer.MIN_VALUE;
        l++;
        r++;
      } 

    return maxElements;

    }
}

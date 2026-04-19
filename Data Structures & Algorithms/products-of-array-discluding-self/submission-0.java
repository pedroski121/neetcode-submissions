class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] response = new int[n];
        int[] preFix = new int[n];
        int[] postFix = new int[n];

        preFix[0] = 1;
        postFix[n-1] = 1;

        for(int i = 1; i<n; i++){
            preFix[i] = preFix[i-1] * nums[i-1];
        }

        for(int i = n - 2; i >= 0; i--){
            postFix[i] = postFix[i+1] * nums[i+1];
        }

        for(int i = 0; i<n; i++){
            response[i] = preFix[i] * postFix[i];
        }

        return response;
    }
}  

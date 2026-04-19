class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
          
       int topRow = 0;
       int bottomRow = matrix.length - 1;

        int[] midRowArr;
       while(topRow <= bottomRow){
       int midRow = (topRow + bottomRow)/2;
       midRowArr = matrix[midRow];

       if(midRowArr[0] > target){
            bottomRow = midRow - 1;
       }
       else if(midRowArr[midRowArr.length - 1] < target){
            topRow = midRow + 1;
       } else {

        break;
       }

       }

       int[] midArr = matrix[(topRow + bottomRow)/2];

       int left = 0;
       int right = midArr.length - 1;

       while(left <= right){
        int mid = (left + right)/2;

        if(midArr[mid] == target){
            return true;
        }
        else if(midArr[mid] > target){
            right = mid - 1;
        } else {
            left = mid + 1;
        }
       }
       return false; 
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){

                int array[] = matrix[i];
                if(array[0] <= target && array[array.length - 1] >= target){

                int firstPointer = 0;
                int lastPointer = matrix[i].length - 1;
                while(firstPointer <= lastPointer){

                    int mid = (firstPointer + lastPointer)/2;

                    if(array[mid] == target){
                        return true;
                    } 
                    else if(array[mid] < target){
                        firstPointer = mid + 1;
                    }
                    else {
                        lastPointer = mid - 1;
                    }

                }
            
            }
        }
        return false;
    }
}

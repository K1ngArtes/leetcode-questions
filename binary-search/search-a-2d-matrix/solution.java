class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // first search the first column
        int i = matrix.length - 1;
        
        while(matrix[i][0] > target) {
            i--;
            if(i == -1) {
                return false;
            }
        }
        
        int l = 0;
        int r = matrix[0].length - 1;
        while(true) {    
            if(l > r) {
                return false;
            }
            if(matrix[i][l] == target || matrix[i][r] == target) {
                return true;
            }
            
            int pivot = l + (r-l)/2;
            if(matrix[i][pivot] == target) {
                return true;
            }
            
            if(matrix[i][pivot] > target) {
                r = pivot - 1;
            } else {
                l = pivot + 1;
            }
        }
    }
}
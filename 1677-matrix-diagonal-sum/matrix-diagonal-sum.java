class Solution {
    // TC O(N) SC O(1)
    public int diagonalSum(int[][] mat) {
        int n = mat.length; 
        int sum = 0;
        
        for(int i = 0; i<n ; i++){
            // Primary Diagonal
            sum = sum + mat[i][i];
            // Secondary Diagonal
            sum = sum + mat[i][n-i-1];
            // Odd Size Matrix
           

        }
         if(n%2==1){
                sum = sum - mat[n/2][n/2]; 
            }
        return sum;    

    }
}
class Solution {
    // TC O(N*M) SC O(N + M)
    public void setZeroes(int[][] matrix) {
        int n= matrix.length; // row
        int m = matrix[0].length; // col

        boolean []row = new boolean[n];
        boolean[] col = new boolean[m];

        // Mark it where is the zero in row and col
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m ; j++){
                if(matrix[i][j]==0){
                    row[i] = true; // row marking
                    col[j] = true; // col marking
                }
            }
        }
        // now it's time to apply 0 (fill)
        for(int i = 0; i<n; i++){
            for(int j = 0 ; j<m; j++){
                if(row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }


    }
}
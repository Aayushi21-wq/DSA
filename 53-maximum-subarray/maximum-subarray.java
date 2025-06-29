class Solution {
    // Approach - 2 TC O(N) SC O(1)
     public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = sum;
        for(int i = 1; i<nums.length; i++){
            sum = sum + nums[i] ; // might be we have negative numbers
            // if sum goes negative
            sum = Math.max(sum , nums[i]);
            max = Math.max(max, sum);

        }
        return max;
     }
    // Brute Force Approach - TC O(N^2) - TLE SC O(1)
    public int maxSubArrayBruteForce(int[] nums) {
        int max = Integer.MIN_VALUE;
        // [-2,1,-3,4,-1,2,1,-5,4] - Array Traverse
        for(int i = 0; i<nums.length; i++){
            int currentSum = 0; // here i store the subarray sum
            for(int j = i; j<nums.length; j++){
                currentSum = currentSum + nums[j];
                max = Math.max(max, currentSum);
            }
        }
        return max;
    }
}
class Solution {
    // Approach - 2 TC O(N)
    // [2,3,-2,4]
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        for(int i = 1; i<nums.length; i++){
            int currentElement = nums[i]; // currentElement can be a negative number
            int tempMax = currentMax ; // old last max it store
            // current Maximum Number
            currentMax = Math.max(currentElement, Math.max(currentMax * currentElement, currentMin * currentElement));
            // current Min Number
            currentMin = Math.min(currentElement, Math.min(tempMax * currentElement, currentMin * currentElement ));
            max = Math.max(max, currentMax);
        }
        return max;
    }
    // Approach - 1 Brute Force TC O(N^2) SC O(1)
    public int maxProductBruteForce(int[] nums) {
        int max = nums[0];
        for(int i = 0; i<nums.length; i++){
            int product = 1;
            for(int j = i ; j<nums.length; j++){
                product = product * nums[j];
                max = Math.max(product, max);
            }
        }
        return max;
    }
}
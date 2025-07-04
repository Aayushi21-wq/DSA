class Solution {
    // TC O(N) SC O(1)
     public int[] runningSum(int[] nums) {
        
        
        for(int i=1 ; i<nums.length; i++){
            nums[i] = nums[i-1] +nums[i];
        }
        return nums;
    }

    // TC O(N) SC O(N)
    public int[] runningSumApproach1(int[] nums) {
        int prefix [] = new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1 ; i<nums.length; i++){
            prefix[i] = prefix[i-1] +nums[i];
        }
        return prefix;
    }
}
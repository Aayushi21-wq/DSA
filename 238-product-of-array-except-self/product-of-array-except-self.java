class Solution {
     public int[] productExceptSelf(int[] nums){
         int prefixProduct[] = new int[nums.length];
          int suffixProduct[] = new int[nums.length];
           int result[] = new int[nums.length];
           prefixProduct[0] = 1;
           for(int i = 1; i<nums.length; i++){
            prefixProduct[i] = prefixProduct[i-1] * nums[i-1];
           }

           suffixProduct[nums.length -1] = 1;
           for(int i = nums.length - 2; i>=0; i--){
            suffixProduct[i] = suffixProduct[i+1] * nums[i+1];
           }

           for( int i = 0; i<nums.length; i++){
            result[i] = prefixProduct[i] * suffixProduct[i];
           }

           return result;
     }
    public int[] productExceptSelfBrutForce(int[] nums) {
        int result[]= new int[nums.length];
      for(int i = 0; i<nums.length; i++){
        int product = 1;
        for(int j = 0; j<nums.length; j++){
            if(i!=j){
                product = product * nums[j];
            }
        }
        result[i] = product;
      }  
      return result;
    }
}
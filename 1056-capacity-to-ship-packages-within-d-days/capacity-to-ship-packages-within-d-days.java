class Solution {
    public int shipWithinDays(int[] weights, int days) {
       int left = 0, right = 0;

       for(int weight : weights) {
        left = Math.max(left , weight);
        right += weight;
       } 
       while(left < right){
        int mid = left + (right - left)/2;
        int requiredDays = 1, currentLoad = 0;

        for (int weight : weights){
            if(currentLoad + weight > mid){
                requiredDays++;
                currentLoad = 0;
            }
            currentLoad += weight;
        }
        if(requiredDays > days){
        left = mid+1;
       }else{
        right = mid;
       }
       }
       return left;
    }

    
}
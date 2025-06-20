class Solution {
    public int[] sortArray(int[] nums) {
        //  Arrays.sort(nums);
        //  return nums;
        mergeSort(nums, 0, nums.length-1);
        return nums;


    }
    void mergeSort(int []nums, int low, int high){
        // Base case 
        if(low>=high){
            return ;
        }
        int mid = low + (high-low)/2;
        // Divide it (Tree Recursion)
        mergeSort(nums, low, mid); // First Half (Sort in Left Side)
        mergeSort(nums, mid+ 1 , high); // Second Half (Sort in Right Side)

        // Merge It
        merge(nums, low, mid, high);
    }
    void merge(int[] nums, int low, int mid , int high){
        List<Integer> result = new ArrayList<>(); 
        int left = low;
        int right = mid + 1;
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                result.add(nums[left]);
                left++;   
            }
            else{
                 result.add(nums[right]);
                 right++;
            }
        }
        // Handle the remainining values
        while(left<=mid){
            result.add(nums[left]);
            left++;
        }
         while(right<=high){
            result.add(nums[right]);
            right++;
        }
        // copy the list (result) into original array that is nums
        for(int i = low; i<=high; i++){
            nums[i] = result.get(i-low);
        }
    }
}
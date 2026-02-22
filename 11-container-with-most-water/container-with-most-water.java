class Solution {
    public int maxArea(int[] height) {
        // Approach-2
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left <= right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int area = h * w;
            max = Math.max(area, max);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max; // <-- Moved inside method
    }
   }
/*
    public int brutemaxArea(int[] height) {
        // Approach 1 Brute Approach-   TC- o(n^2) sc 0(1)
        for(int i =0;i<height.length;i++){
            for(int j =i+1;j<height.length;j++){
                int h = Math.min(height[i],height[j]);
                int w = j-1;
                int area = h*w;
                max = Math.max(area,max);
            }
        }
        return max;
    }
}*/
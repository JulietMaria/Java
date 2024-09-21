//https://leetcode.com/problems/trapping-rain-water/
//https://www.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
class Solution {
    public int trap(int[] height) {
        int n = height.length;  // Get the length of the height array
        if (n <= 2) return 0;   // If there are less than 3 bars, no water can be trapped
        
        int left = 1, right = n - 2;       // Initialize pointers: 'left' starts from index 1 and 'right' from index n-2
        int maxLeft = height[0], maxRight = height[n - 1]; // Set initial maxLeft and maxRight as the first and last elements
        int ans = 0;                       // This will store the total trapped water
        
        // Continue while the left pointer is less than or equal to the right pointer
        while (left <= right) {
            // If the maximum height on the left is less than the maximum height on the right
            if (maxLeft < maxRight) {
                // If the current height at 'left' is greater than maxLeft, update maxLeft
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    // Otherwise, calculate trapped water at 'left' and add to 'ans'
                    ans += maxLeft - height[left];
                }
                left++;  // Move the left pointer one step to the right
            } else {
                // If maxRight is less than or equal to maxLeft
                // If the current height at 'right' is greater than maxRight, update maxRight
                if (height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                    // Otherwise, calculate trapped water at 'right' and add to 'ans'
                    ans += maxRight - height[right];
                }
                right--; // Move the right pointer one step to the left
            }
        }
        
        return ans; // Return the total trapped water
    }
}
//TC:O(n) SC: O(1)

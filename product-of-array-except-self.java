//https://leetcode.com/problems/product-of-array-except-self/
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        
        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }
}
/*
Time Complexity
Prefix Loop: O(n)
Postfix Loop: O(n)
Total: O(n)
Space Complexity
Output array: O(n)
Extra variables (postfix): O(1)
Total: O(n) (for output array, which is required by the problem).
*/

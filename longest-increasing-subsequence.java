//https://leetcode.com/problems/longest-increasing-subsequence/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> lis = new ArrayList<>();

        for (int num : nums) {
            int lb = lowerBound(lis, num);
            if (lb == lis.size()) {
                lis.add(num); // Add to the end if it's the largest element
            } else {
                lis.set(lb, num); // Replace the element at the position
            }
        }

        return lis.size();
    }

    // Custom implementation of lower_bound
    private int lowerBound(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; // Low is the index of the first element >= target
    }
}
/*
Time Complexity:O(nlogn)
Space Complexity: O(n)
*/

class Solution {//https://leetcode.com/problems/two-sum/
    public int[] twoSum(int[] nums, int target) {
         Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int temp = target - nums[i];
            if (numMap.containsKey(temp)) {
                return new int[]{numMap.get(temp), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[]{}; // No solution found
    }
}

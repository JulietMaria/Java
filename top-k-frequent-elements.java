//https://leetcode.com/problems/top-k-frequent-elements/description/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each number using a HashMap.
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Create an array of buckets where index represents frequency.
        // The bucket stores lists of numbers with that frequency.
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : frequencyMap.keySet()) {
            int freq = frequencyMap.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        
        // Step 3: Collect the top k frequent elements from the buckets, starting from the highest frequency.
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }
        
        // Convert result list to an array and return.
        return result.stream().mapToInt(i -> i).toArray();
    }
}
/*
Time Complexity: O(n)
Space Complexity: O(n)
*/

//https://leetcode.com/problems/group-anagrams/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];// Create a count array to record the frequency of each character in the string
            for (char c : s.toCharArray()) {  // Populate the count array based on the characters in the string
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);// Convert the count array to a string representation to use as a unique key
            res.putIfAbsent(key, new ArrayList<>());// If the key does not exist in the map, add it with a new list
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());

    }
}
/*
Time complexity: O(m∗n)
Space complexity: O(m)
Where m is the number of strings and n is the length of the longest string.
*/

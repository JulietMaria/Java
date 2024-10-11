//https://leetcode.com/problems/majority-element/
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> freqMap=new HashMap<Integer,Integer>();
        int majEle=0;
        for(int num:nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
            if(freqMap.get(num)>nums.length/2){
                majEle=num;
            }
        }
        return majEle;
    }
}

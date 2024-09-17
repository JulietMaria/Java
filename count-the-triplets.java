//https://www.geeksforgeeks.org/problems/count-the-triplets4615/1
class Solution {
    int countTriplet(int nums[], int n) {
        // code here
        int count=0;
        Arrays.sort(nums);
        for(int i=nums.length-1; i>=2;i--){//fix max element
            int left =0;// two ponter approach
            int right = nums.length-2;
            while(left<right){
                int sum = nums[left]+nums[right];
                if(sum==nums[i]){
                 count++; 
                 left++;
                 right--;
                }
                else if (sum>nums[i]) right--;
                else left++;
            }
        }
        return count;
    }
}

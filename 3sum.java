class Solution {//https://www.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
    // Should return true if there is a triplet with sum equal
    // to x in arr[], otherwise false
    public static boolean find3Numbers(int arr[], int n, int x) {
    Arrays.sort(arr);
        // Your code Here
        for (int i=0;i<n-2;i++){
            int left=i+1;
            int right=n-1;
            while(left<right){
                int sum=arr[i]+arr[left]+arr[right];
                if(sum==x){//when target is x
                     return true;
                }else if(sum<x){
                    left++;
                }else{
                    right--;
                }
            }
        }
       return false;
    }
}

//target=0 https://leetcode.com/problems/3sum/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res  = new HashSet<>();
        if(nums.length==0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){//fix 1st element
            int left =i+1;//2 sum two ponter approach
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0)res.add(Arrays.asList(nums[i],nums[left++],nums[right--])); 
                else if (sum>0) right--;
                else if (sum<0) left++;
            }
        }
        return new ArrayList<>(res);
    }
}

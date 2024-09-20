//https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
//https://takeuforward.org/arrays/longest-subarray-with-sum-k-postives-and-negatives/
class Solution {//optimal approach
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr(int a[], int n, int k) {
       HashMap<Integer,Integer> preSumMap=new HashMap<>();
       int sum=0;
       int maxLen=0;
       for(int i=0;i<n;i++){
           sum+=a[i];
           if(sum==k){
               maxLen=Math.max(maxLen,i+1);
           }
           if(preSumMap.containsKey(sum-k)){
               maxLen=Math.max(maxLen,i-preSumMap.get(sum-k));
           }
           if(!preSumMap.containsKey(sum)){
               preSumMap.put(sum,i);
           }
       }
        return maxLen;
    }
}
//TC = 0(n) and Sc = 0(n)

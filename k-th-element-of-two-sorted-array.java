//https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
//https://medium.com/@aditya-patel/binary-search-k-th-element-of-two-sorted-arrays-leetcode-medium-c-f019d42438a
//https://khilesh.medium.com/k-th-element-of-two-sorted-arrays-464f535f7fc4
//solution1
class Solution {
    public long kthElement(int k, int fArray[], int sArray[]) {
        int n=fArray.length,m=sArray.length;
     // Ensure binary search is performed on the smaller array
        if (n > m) {
            return kthElement(k,sArray, fArray); // Swap arrays if fArray is larger than sArray
        }

        // Define binary search boundaries
        int lowerLimit = Math.max(0, k - m); // Minimum number of elements to take from fArray
        int upperLimit = Math.min(k, n);     // Maximum number of elements to take from fArray

        // Binary search loop
        while (lowerLimit <= upperLimit) {
            // Calculate mid points (separators) for both arrays
            int fASeperator = (lowerLimit + upperLimit) / 2;
            int sASeperator = k - fASeperator;

            // Find the elements around the cuts (partitions)
            int elementBeforefAS = fASeperator == 0 ? Integer.MIN_VALUE : fArray[fASeperator - 1];
            int elementAfterfAS = fASeperator == n ? Integer.MAX_VALUE : fArray[fASeperator];
            int elementBeforesAS = sASeperator == 0 ? Integer.MIN_VALUE : sArray[sASeperator - 1];
            int elementAftersAS = sASeperator == m ? Integer.MAX_VALUE : sArray[sASeperator];

            // Check if valid partition is found
            if (elementBeforefAS > elementAftersAS) {
                // Move left in fArray (reduce the elements from fArray)
                upperLimit = fASeperator - 1;
            } else if (elementBeforesAS > elementAfterfAS) {
                // Move right in fArray (increase the elements from fArray)
                lowerLimit = fASeperator + 1;
            } else {
                // Valid partition is found, return the maximum element from the left partitions
                return (long) Math.max(elementBeforefAS, elementBeforesAS);
            }
        }

        // In case no valid partition is found (this should never happen for valid inputs)
        return 0;
        
    }
}
//time complexity is O(log(min(n, m)))
//space complexity is O(1)

//solution2
public class UsingMinHeap {
    public static void main(String[] args) {
        int arr1[] = { 2, 3, 6, 7, 9 };
        int arr2[] = { 1, 4, 8, 10 };
        int k = 5;
        System.out.print(kth(arr1, arr2, 5, 4, k));
    }

    private static int kth(int[] arr1, int[] arr2, int n, int m, int k) {
    //    Declaring a min heap
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    // pushing elements from arr1 to min-heap
    for(int i=0;i<n;i++){
        pq.offer(arr1[i]);
    }
    // pushing elements from arr2 to min-heap
    for(int i =0;i<m;i++){
        pq.offer(arr2[i]);
    }
    // popping out k-1 elements
    while(k-- > 1){
        pq.remove();
    }
// return the top elements of the pq
    return pq.peek();
    }
}

// Time Complexity: O(NlogN)
// Auxiliary Space: O(m+n)

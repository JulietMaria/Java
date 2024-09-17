//https://www.geeksforgeeks.org/problems/intersection-of-two-arrays2404/1
class Solution {
    // Function to return the count of the number of elements in
    // the intersection of two arrays.
    public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (set.contains(b[i])) {
                count++;
                set.remove(b[i]); 
                
            }
        }
        return count; 
    }
}

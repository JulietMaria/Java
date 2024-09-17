//https://www.geeksforgeeks.org/problems/union-of-two-arrays3538/1
class Solution {
    public static int doUnion(int arr1[], int arr2[]) {
        HashSet<Integer> unionSet = new HashSet<>();
        for (int num : arr1) {
            unionSet.add(num);
        }
        for (int num : arr2) {
            unionSet.add(num);
        }
        return unionSet.size();
    }
}

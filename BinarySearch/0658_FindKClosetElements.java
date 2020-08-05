//https://leetcode.com/problems/find-k-closest-elements/
// the below solution works but is ugly. The idea is to find the left most qualified position.
// to try another method

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        // 80 90 100 110 111 112
        // k = 4 x = 95
        
        List<Integer> res = new LinkedList<>();
        int r = 0;
        // since the array is sorted, the below block can be replaced with a binary search to reduce the complexity to O(logN)
        for (int i = 0 ; i < arr.length; i++) {
            if (x <= arr[i]) {
                r = i;
                break;
            }
        }
        int l = r - 1;
        int count = 0;
        while (l >= 0 && count < k) {
            if (x - arr[l] <= arr[r] - x) {
                l--;
                count++;
            }
            else {
                r++;
                count++;
                if (r >= arr.length) {
                    l -= k - count;
                    break;
                }
            }
        }
        int j = 0;
       while (j < k && l < arr.length - 1) {
           res.add(arr[l+1]);
           l++;
           j++;
       }
        return res;
    }
}

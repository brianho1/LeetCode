class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // 3 7 9 0 0 0
        // 2 10 11
        // 2 3 7 9 10 11
        // 2 
        
        int j = 0;
        int i = 0;
        int k = 0;
        int[] result = new int[m+n];
        while (k < n + m) {
            if (i <= m - 1 && nums1[i] <= nums2[j]) {
                result[k] = nums1[i];
                i++;
            }
            else {
                result[k] = nums2[j];
                j++;
            }
            k++;
        }
        nums1 = result;
    }
}

// 1 2 3 0  0 0 
// 2 5 6
//0
//0

// 1 2 2 3 
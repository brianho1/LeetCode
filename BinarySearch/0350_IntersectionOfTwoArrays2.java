class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
    int k = 0;
    int[] result = new int[Math.min(nums1.length, nums2.length)];
    Map<Integer, Integer> m1 = new HashMap<>();
    for (int i = 0; i < nums1.length; i++) {
        if (!m1.containsKey(nums1[i])) {
            m1.put(nums1[i],1);
        }
        else {
            m1.put(nums1[i], m1.get(nums1[i]) + 1);
        }
    }
    
    for (int j = 0; j <nums2.length; j++) {
        if (m1.getOrDefault(nums2[j], 0) > 0) {
            result[k] = nums2[j];
            m1.put(nums2[j], m1.get(nums2[j])-1);
            k++;
        }
    }
    int[] result2 = new int[k];
        for (int i = 0; i < k; i++) {
            result2[i] = result[i];
        }
    return result2;
    }
}
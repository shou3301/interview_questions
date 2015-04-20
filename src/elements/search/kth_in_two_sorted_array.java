public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 0) {
            return (findKth(nums1, nums2, 0, 0, total / 2) + findKth(nums1, nums2, 0, 0, total / 2 + 1)) / 2.0;
        } else {
            return findKth(nums1, nums2, 0, 0, total / 2 + 1);
        }
    }
    
    private int findKth(int[] nums1, int[] nums2, int m, int n, int k) {
        int len1 = nums1.length - m;
        int len2 = nums2.length - n;
        
        if (len1 > len2) return findKth(nums2, nums1, n, m, k);
        
        // All edge cases.
        if (len1 == 0) {
            return nums2[n + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[m], nums2[n]);
        }
        
        int p = Math.min(len1, k / 2);
        int q = k - p;
        
        if (nums1[m + p - 1] <= nums2[n + q - 1]) {
            return findKth(nums1, nums2, m + p, n, k - p);
        } else {
            return findKth(nums1, nums2, m, n + q, k - q);
        }
    }
}
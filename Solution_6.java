
/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
*/
class Solution_6
{
    public static void main(String[] args) {
        Solution s1 = new Solution();
        double s = s1.findMedianSortedArrays(new int[]{1,3},
                new int[]{2});
        System.out.println(s);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (isValid(nums1, nums2)){
            int nums3[] = new int[nums1.length + nums2.length];
            int index = 0;
            int i=0, j=0;
            while(i < nums1.length && nums2.length > j){
                if (nums1[i] < nums2[j]){
                    nums3[index++] = nums1[i++];
                }else{
                    nums3[index++] = nums2[j++];
                }
            }
            while (nums1.length > i){
                nums3[index++] = nums1[i++];
            }
            while (nums2.length > j){
                nums3[index++] = nums2[j++];
            }
            int mid = (nums3.length/2);
            if (nums3.length%2 == 0){
                System.out.println(nums3[mid-1] + " : " +nums3[mid]);
                return (nums3[mid-1] + nums3[mid])/2.00000;
            }else{
                return nums3[mid];
            }
        }
        return 0.0;
    }
    private boolean isValid(int[] nums1, int[] nums2){
        double MAX = Math.pow(10, 6);
        double MIN = -MAX;

        for(int i : nums1){
            if(!(MIN <= i && i <= MAX)){
                return false;
            }
        }
        for(int i : nums2){
            if(!(MIN <= i && i <= MAX)){
                return false;
            }
        }
        int n = nums1.length;
        int m = nums2.length;

        return (0 <= n && n <= 1000) &&
                (0 <= m && m <= 1000) &&
                (1 <= (m+n) && (m+n) <= 2000);
    }
}
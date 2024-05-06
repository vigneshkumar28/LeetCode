class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length+nums2.length;
        double[] arr= new double[n];
        for(int i=0;i<nums1.length;i++){
            arr[i] = nums1[i];
        }
        int n1=nums1.length;
        for(int i=0;i<nums2.length; i++){
            arr[i+n1]= nums2[i];
        }
        Arrays.sort(arr);
        double median=0.00000;
        if(n%2 != 0)
            median= arr[n/2];
        else if(n%2==0)
            median = (arr[n/2]+arr[n/2 - 1])/2;
        return median;
    }
}
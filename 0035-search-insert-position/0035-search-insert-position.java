class Solution {
    public int searchInsert(int[] nums, int target) {
        int index= Arrays.binarySearch(nums, target);
        if(index>=0)
            return index;
        return -(index+1);
    }
}
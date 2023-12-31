class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if(nums.length <=1 || nums == null || indexDiff <= 0 || valueDiff<0) return false;
        TreeSet<Long> result = new TreeSet<>();
        for(int i=0; i<nums.length; i++){
            Long num = (long)nums[i];
            Long flr = result.floor(num + valueDiff);
            Long cling = result.ceiling(num - valueDiff);
            if((flr != null && flr >= num) || (cling != null && cling <= num)) return true;
            result.add(num);
            if( i >= indexDiff)
                result.remove((long)nums[i-indexDiff]);
        }
        return false;
    }
}
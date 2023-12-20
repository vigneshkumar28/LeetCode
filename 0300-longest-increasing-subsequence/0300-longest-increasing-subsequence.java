class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> results = new ArrayList<>();
        for(int num : nums){
            int i = Collections.binarySearch(results, num);
            if(i<0){
                i = -(i+1);
            }
            if(i == results.size())
                results.add(num);
            else
                results.set(i, num);
        }
        return results.size();
    }
}
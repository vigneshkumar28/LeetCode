class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count=0;
        int currentSum=0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums){
            currentSum += num;
            if(currentSum == goal)
                count++;
            if(freqMap.containsKey(currentSum-goal))
                count += freqMap.get(currentSum - goal);
            freqMap.put(currentSum, freqMap.getOrDefault(currentSum, 0)+1);
        }
        return count;
    }
}
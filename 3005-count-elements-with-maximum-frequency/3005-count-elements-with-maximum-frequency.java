class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i: nums)
            freqMap.put(i, freqMap.getOrDefault(i, 0)+1);
        int maxFreq=0;
        for(int freq: freqMap.values()){
            maxFreq = Math.max(maxFreq, freq);
        }
        int totalMaxFreq=0;
        for(int freq: freqMap.values()){
            if(freq == maxFreq)
                totalMaxFreq++;
        }
        return totalMaxFreq*maxFreq;
    }
}
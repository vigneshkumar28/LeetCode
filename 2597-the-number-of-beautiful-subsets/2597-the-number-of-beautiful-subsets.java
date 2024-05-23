class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        int totalCount=1;
        Map<Integer, Map<Integer, Integer>> freqMap = new TreeMap<>();
        for(int num: nums){
            Map<Integer, Integer> remainderFreq = freqMap.getOrDefault(num%k, new TreeMap<>());
            remainderFreq.put(num, remainderFreq.getOrDefault(num, 0)+1);
            freqMap.put(num%k, remainderFreq);
        }
        for(Map.Entry<Integer, Map<Integer, Integer>>  entry: freqMap.entrySet()){
            int prevNum = -k, prev2=0, prev1=1, curr=1;
            for(Map.Entry<Integer, Integer> freqEntry: entry.getValue().entrySet()){
                int num= freqEntry.getKey();
                int freq = freqEntry.getValue();
                int skip=prev1;
                int take;
                if(num - prevNum == k){
                    take = ((1<<freq)-1)*prev2;
                }else{
                    take = ((1<<freq)-1)*prev1;
                }
                curr = skip+take;
                prev2 = prev1;
                prev1 = curr;
                prevNum = num;
            }
            totalCount *= curr;
        }
        return totalCount-1;
    }
}
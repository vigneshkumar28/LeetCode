class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if( hand.length % groupSize != 0)
            return false;
        Map<Integer, Integer> freqMap = new TreeMap<>();
        for(int num: hand){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        while(freqMap.size() > 0){
            int smallCard = freqMap.entrySet().iterator().next().getKey();
            for(int i=0;i<groupSize; i++){
                if(!freqMap.containsKey(smallCard+i)) return false;
                freqMap.put(smallCard+i, freqMap.get(smallCard+i)-1);
                if(freqMap.get(smallCard+i)==0)
                    freqMap.remove(smallCard+i);
            }
        }
        return true;
    }
}
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i: arr){
            freqMap.put(i, freqMap.getOrDefault(i, 0)+1);
        }
        List<Integer> freq = new ArrayList<>(freqMap.values());
        Collections.sort(freq);
        int elementsRemoved=0;
        for(int i=0;i<freq.size();i++){
            elementsRemoved += freq.get(i);
            if(elementsRemoved > k)
                return freq.size()-i;
        }
        return 0;
    }
}
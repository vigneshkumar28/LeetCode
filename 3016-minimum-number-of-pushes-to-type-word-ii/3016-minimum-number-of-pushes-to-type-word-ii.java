class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char c: word.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
        }
        //stor in descending order freq
        PriorityQueue<Integer> minHeap= new PriorityQueue<>((a, b) -> b-a);
        minHeap.addAll(freqMap.values());
        int totalPushes=0;
        int index=0;
        while(!minHeap.isEmpty()){
            totalPushes += (index/8 + 1)*minHeap.poll();
            index++;
        }
        return totalPushes;
    }
}
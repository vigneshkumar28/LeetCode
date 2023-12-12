class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int n = nums.length;
        for(int num: nums)
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> freqMap.get(a)-freqMap.get(b));
        for(int num: freqMap.keySet()){
            minHeap.offer(num);
            if(minHeap.size() > k)
                minHeap.poll();
        }
        int[] result = new int[k];
        for(int i=0; i<k; i++){
            result[i] =minHeap.poll();
        }
        return result;
    }
}
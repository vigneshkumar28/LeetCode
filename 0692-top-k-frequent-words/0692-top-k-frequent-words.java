class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String s: words){
            map.put(s, map.getOrDefault(s,0)+1);
        }
        PriorityQueue<String> maxHeap = new PriorityQueue<>((a,b)->{
            int freqA = map.get(a);
            int freqB = map.get(b);
            if(freqA == freqB)
                return a.compareTo(b);
            return freqB-freqA;
        });
        maxHeap.addAll(map.keySet());
        List<String> result = new ArrayList<>();
        while( k > 0 && !maxHeap.isEmpty()){
            result.add(maxHeap.poll());
            k--;
        }
        return result;
    }
}
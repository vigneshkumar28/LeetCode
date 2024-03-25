class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i: nums){
            freq.put(i, freq.getOrDefault(i, 0)+1);
        }
        List<Integer> result= new ArrayList<>();
        for(Map.Entry<Integer, Integer> i: freq.entrySet()){
            if(i.getValue() > 1)
                result.add(i.getKey());
        }
        return result;
    }
}
class Solution {
    public int majorityElement(int[] nums) { 
        int n = nums.length;
        Map<Integer, Integer> results = new HashMap<>();
        for(int num: nums){
            results.put(num, results.getOrDefault(num, 0)+1);
        }
        for(Map.Entry<Integer, Integer> i : results.entrySet()){
            if( i.getValue() > n/2)
                return i.getKey();
        }
        return 0;
    }
}
class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i: nums){
            freq.put(i, freq.getOrDefault(i, 0)+1);
        }
        int sum = 0;
        for(int i: freq.values()){
            if(i == 1){
                return -1;
            }
            if(i %3 == 0){
                 sum += i/3;
            }else{
                sum += i/3 +1;
            }
        }
        return sum;
    }
}
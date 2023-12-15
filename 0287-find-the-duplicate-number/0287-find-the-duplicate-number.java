class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        for(int num:nums){
            result.put(num, result.getOrDefault(num, 0)+1);
        }
        for(Map.Entry<Integer, Integer> i: result.entrySet()){
            int num = i.getKey();
            int count = i.getValue();
            if(count > 1)
                return num;
        }
        return 0;
    }
}
class Solution {
    public List<Integer> intersection(int[][] nums) {
        int n = nums.length;
        Map<Integer, Integer> results = new HashMap<>();
        for(int i=0; i<nums.length; i++)
            for(int j = 0; j< nums[i].length; j++)
                results.put(nums[i][j], results.getOrDefault(nums[i][j], 0)+1);
        Set<Integer> output = new TreeSet<>();
        for(Map.Entry<Integer, Integer> i: results.entrySet()){
            if(i.getValue() == n)
                output.add(i.getKey());
        }
        return new ArrayList<>(output);
    }
}
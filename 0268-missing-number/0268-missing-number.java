class Solution {
    public int missingNumber(int[] nums) {
        Map<Integer, Integer> results = new HashMap<>();
        int n = nums.length;
        for(int i =0; i<n; i++){
            int num = nums[i];
            results.put(num, results.getOrDefault(num, 0)+1);
        }
        for(int i = 0; i<=n; i++){
            if(!results.containsKey(i))
                return i;
        }
        return -1;
    }
}
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtracking(results, new ArrayList<>(),nums, 0);
        return results;
    }
    private static void backtracking(List<List<Integer>> results, List<Integer> temp, int[] nums, int start){
        int n = nums.length;
        if(start > n){
            return;
        }
        results.add(new ArrayList<>(temp));
        for(int i =start; i<n; i++){
            temp.add(nums[i]);
            backtracking(results, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
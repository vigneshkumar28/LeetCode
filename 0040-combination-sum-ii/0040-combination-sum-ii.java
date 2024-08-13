class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      Arrays.sort(candidates);
      List<List<Integer>> results = new ArrayList<>();
        checkCombinations(results, new ArrayList<>(), candidates, target, 0);
        return results;
    }
    //backtracking
    private static void checkCombinations(List<List<Integer>> results, List<Integer> temp, int[] candidates, int target, int start){
        if(target < 0){
            return;
        }else if(target == 0){
            results.add(new ArrayList<>(temp)); 
            return;
        }
        int n = candidates.length;
        for(int i=start; i<n; i++){
            if(i>start && candidates[i] == candidates[i-1])
                continue;
            temp.add(candidates[i]);
            checkCombinations(results, temp,candidates, target-candidates[i], i+1);
            temp.remove(temp.size()-1);
        }
    }
}
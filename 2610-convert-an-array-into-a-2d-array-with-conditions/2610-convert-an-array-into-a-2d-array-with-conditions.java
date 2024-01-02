class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int num: nums){
            boolean found = false;
            for(List<Integer> row: result){
                if(!row.contains(num)){
                    row.add(num);
                    found = true;
                    break;
                }
            }
            if(!found){
                List<Integer> newRow = new ArrayList<>();
                newRow.add(num);
                result.add(newRow);
            }
        }
        return result;
    }
}
class Solution {
    public int[] findErrorNums(int[] nums) {
        List<Integer> indexList = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int id = Math.abs(nums[i])-1;
            if(nums[id] <0){
                indexList.add(id+1);
            }else{
                nums[id] = -nums[id];
            }
        }
        for(int i=0;i<nums.length; i++){
            if(nums[i]>0){
                indexList.add(i+1);
                break;
            }
        }
        int[] result = new int[indexList.size()];
        for(int i=0;i<result.length;i++){
            result[i]=indexList.get(i);
        }
        return result;
    }
}
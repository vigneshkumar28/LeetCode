class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> positiveArr = new ArrayList<>();
        List<Integer> negativeArr = new ArrayList<>();
        for(int i: nums){
            if(i>=0)
                positiveArr.add(i);
            else
                negativeArr.add(i);
        }
        int p1=0, n1=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                nums[i]=positiveArr.get(p1);
                p1++;
            }else{
                nums[i]=negativeArr.get(n1);
                n1++;
            }
        }
        return nums;
    }
}
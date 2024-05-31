class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int xorNum=0;
        for(int num: nums){
            xorNum ^= num;
        }
        int setBit = xorNum & ~(xorNum-1);
        
        for(int num: nums){
            if((setBit & num) !=0){
                res[0] ^= num;
            }else{
                res[1] ^= num;
            }
        }
        return res;
    }
}
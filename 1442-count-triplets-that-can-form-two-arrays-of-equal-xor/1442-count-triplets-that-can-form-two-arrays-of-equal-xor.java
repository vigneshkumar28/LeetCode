class Solution {
    public int countTriplets(int[] arr) {
        //O(n2) - time, o(1) - space
        int count=0;
        for(int i=0;i<arr.length; i++){
            int xor=0;
            for(int j=i; j<arr.length; j++){
                xor ^= arr[j];
                if(xor == 0)count += (j-i);
            }
        }
        return count;
    }
}
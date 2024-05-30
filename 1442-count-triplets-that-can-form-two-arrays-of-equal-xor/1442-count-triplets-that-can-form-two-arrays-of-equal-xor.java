class Solution {
    public int countTriplets(int[] arr) {
        int count=0;
        //n^3 time complexity, 1 space complexity
        for(int start=0;start<arr.length; start++){
            int xorA=0;
            for(int mid=start+1; mid<arr.length; mid++){
                xorA ^= arr[mid-1];
                int xorB = 0;
                for(int end=mid;end<arr.length; end++){
                    xorB ^= arr[end];
                    if(xorA == xorB)
                        count++;
                }
            }
        }
        return count;
    }
}
class Solution {
    public int xorOperation(int n, int start) {
        int xored=0;
        int count=0;
        for(int i=0;count<n;count++,i++){
            xored ^= (start+ 2*i);
        }
        return xored;
    }
}
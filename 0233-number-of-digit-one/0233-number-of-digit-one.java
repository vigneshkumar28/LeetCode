class Solution {
    public int countDigitOne(int n) {
        int res= 0;
        for(int i=1;i<=n; i*=10){
            int div = i*10;
            int qunt= n/div;
            int remainder = n%div;
            res +=qunt*i;
            if(remainder >= i)
                res += Math.min(remainder-i+1, i);
        }
        return res;
    }
}
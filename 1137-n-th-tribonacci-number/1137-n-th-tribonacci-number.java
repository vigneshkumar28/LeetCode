class Solution {
    public int tribonacci(int n) {
        //dp
        if(n<2)
            return n;
        int a=0;
        int b=1;
        int c=a+b;
        for(int i=3; i<=n; i++){
            int sum = a+b+c;
            a=b;
            b=c;
            c=sum;
        }
        return c;
    }
}
class Solution {
    public boolean isUgly(int n) {
        if(n == 0) return false;
        while(n % 2 == 0) n /= 2;
        if(n == 0) return false;
        while(n%3 ==0) n/=3;
        if(n == 0) return false;
        while(n%5 == 0) n/=5;
        if(n == 0) return false;
        return n == 1;
    }
}